package com.jwjjgs.robotcenter.nettyServer;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.common.handler.MsgInfo;
import com.jwjjgs.robotcenter.common.threadPool.DisMonitorTaskServer;
import com.jwjjgs.robotcenter.handler.BaseHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;

import java.net.InetAddress;

public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    /**
     * 任务线程分发服务
     */
    private DisMonitorTaskServer server = null;

    /**
     * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     *
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        String welcome = "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!";
        Msg.Student.Response response = Msg.Student.Response.newBuilder().setOk(101).build();
        ctx.writeAndFlush(response);
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
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        if (this.server == null) {
            this.server = new DisMonitorTaskServer(10, "玩家监听", 2000L, 10000L);
        }

        //包装消息
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setType(1);
        msgInfo.setMessage(msg);
        msgInfo.setPlayerId(12345);
        msgInfo.setCtx(ctx);
//        this.server.putMsg(msgInfo, 1);
        //创建handler
        String simpleName = msg.getClass().getSimpleName();
        BaseHandler<GeneratedMessageV3> handler = CenterContextAware.createHandler(simpleName);
        handler.execute(msgInfo);
    }
}
