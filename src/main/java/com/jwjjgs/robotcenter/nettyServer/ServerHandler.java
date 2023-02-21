package com.jwjjgs.robotcenter.nettyServer;

import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * 处理主handler
 */
@Component
public class ServerHandler extends SimpleChannelInboundHandler<PackageClass> {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);

    private static CenterContextAware aware = CenterContextAware.getInstance();

    /**
     * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     *
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        aware.putCtx(address.getHostString(), ctx);

        //连接成功返回
        Package.ConnectSuc.Builder response = Package.ConnectSuc.newBuilder();
        response.setOk(1)
                .build();
        ctx.writeAndFlush(response);
        log.info("----------RamoteAddress : " + address.getHostString() + " active !");
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
        BaseHandlerImpl<PackageClass> handler = aware.createHandler(msg.getMsgName());
        handler.setCtx(ctx);
        handler.setContent(handler.deserialize(msg.getData()));
        handler.execute();
    }

    /**
     * 通道关闭
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        aware.delCtx(address.getHostString());
        log.info("----------RamoteAddress : " + address.getHostString() + " remove!");
        super.handlerRemoved(ctx);
    }
}
