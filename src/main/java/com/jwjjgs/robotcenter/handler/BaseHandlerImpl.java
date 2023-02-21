package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.Message;
import io.netty.channel.ChannelHandlerContext;

public abstract class BaseHandlerImpl<T extends Message> implements BaseHandler{
    private ChannelHandlerContext ctx;
    private T msg;

    /**
     * 返回消息
     * @param msg
     */
    public void sendMsg(Message msg){
        ctx.writeAndFlush(msg);
    }

    /**
     * 设置处理数据
     * @param msg
     */
    public void setContent(T msg){
        this.msg = msg;
    }

    /**
     * 获取处理msg
     * @return
     */
    public T getMsg(){
        return this.msg;
    }

    /**
     * 设置处理连接
     * @param ctx
     */
    public void setCtx(ChannelHandlerContext ctx){
        this.ctx = ctx;
    }
}
