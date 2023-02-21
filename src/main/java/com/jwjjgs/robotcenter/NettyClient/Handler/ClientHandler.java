package com.jwjjgs.robotcenter.NettyClient.Handler;

import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<PackageClass> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PackageClass msg) throws Exception {
        byte[] data = msg.getData();
        Package.ConnectSuc connectSuc = Package.ConnectSuc.parseFrom(data);
        System.out.println("-------返回:"+ connectSuc.getOk());
        //System.out.println("Server say : " + msg.toString());
    }

    /**
     *
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        Msg.Student.Builder builder = Msg.Student.newBuilder();
        builder.setAge(5);
        builder.setName("body");
        ctx.writeAndFlush(builder.build());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client close ");
        super.channelInactive(ctx);
    }

}
