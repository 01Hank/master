package com.jwjjgs.robotcenter.nettyServer;


import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.SocketAddress;

public class ServerHandler extends SimpleChannelInboundHandler<PackageClass> {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
    @Autowired
    private CenterContextAware awar;

    /**
     * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     *
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        awar.putCtx(socketAddress.toString(), ctx);

        Package.ConnectSuc.Builder builder = Package.ConnectSuc.newBuilder();
        builder.setOk(1).build();
        ctx.writeAndFlush(builder);

        log.info("----------RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        super.channelActive(ctx);
    }

    /**
     * 处理客户端发送的消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PackageClass msg) throws Exception {
        BaseHandlerImpl<PackageClass> handler = awar.createHandler(msg.getMsgName());
        handler.setCtx(ctx);
        handler.execute(msg);
    }

    /**
     * 通道关闭
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        SocketAddress socketAddress = ctx.channel().remoteAddress();
        awar.delCtx(socketAddress.toString());

        log.info("----------RamoteAddress : " + socketAddress.toString() + " remove!");
        super.handlerRemoved(ctx);
    }
}
