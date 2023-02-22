package com.jwjjgs.robotcenter.nettyClient.Handler;

import com.google.protobuf.ByteString;
import com.jwjjgs.robotcenter.nettyServer.util.PackageClass;
import com.jwjjgs.robotcenter.nettyServer.util.PackageHead;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class ClientHandler extends SimpleChannelInboundHandler<PackageClass> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PackageClass msg) throws Exception {
        ByteString data = msg.getData();
        Package.ConnectSuc connectSuc = Package.ConnectSuc.parseFrom(data);
        System.out.println("-------返回:"+ connectSuc.getOk());
        //System.out.println("Server say : " + msg.toString());
    }

    /**
     *
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        Msg.Student.Builder msg = Msg.Student.newBuilder();
        msg.setAge(5)
                .setName("body");

        Msg.Student build = msg.build();
        PackageHead head = new PackageHead();
        head.setCreateDate(new Date());
        PackageClass packageClass = new PackageClass("Student", head, build.toByteString());
        ctx.writeAndFlush(packageClass);
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client close ");
        super.channelInactive(ctx);
    }

}
