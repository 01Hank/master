package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.Message;
import io.netty.channel.ChannelHandlerContext;

public abstract class BaseHandlerImpl<PackageClass> implements BaseHandler{
    private ChannelHandlerContext ctx;

    /**
     * 返回消息
     * @param msg
     */
    public void sendMsg(Message.Builder msg){
        ctx.writeAndFlush(msg);
    }

    public void setCtx(ChannelHandlerContext ctx){
        this.ctx = ctx;
    }
}
