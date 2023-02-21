package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import io.netty.channel.ChannelHandlerContext;
import java.io.IOException;

/**
 * handler抽象类
 * @param <T> Message具体proto类
 */
public abstract class BaseHandlerImpl<T extends Message> implements BaseHandler{
    public static CenterContextAware aware = CenterContextAware.getInstance();

    private ChannelHandlerContext ctx;
    private T msg;

    public  abstract T deserialize(byte[] data) throws IOException;

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
