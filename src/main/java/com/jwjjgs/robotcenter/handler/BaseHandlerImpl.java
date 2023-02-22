package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.nettyServer.util.PackageClass;
import com.jwjjgs.robotcenter.nettyServer.util.PackageHead;
import io.netty.channel.ChannelHandlerContext;
import java.io.IOException;
import java.util.Date;

/**
 * handler抽象类
 * @param <T> Message具体proto类
 */
public abstract class BaseHandlerImpl<T extends Message> implements BaseHandler{
    public static CenterContextAware aware = CenterContextAware.getInstance();

    private ChannelHandlerContext ctx;
    private T msg;

    public  abstract T deserialize(ByteString data) throws IOException;


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

    /**
     * 返回消息
     * @param msg
     */
    public void sendMsg(Message msg){
        PackageHead head = new PackageHead();
        head.setCreateDate(new Date());
        PackageClass packageClass = new PackageClass(msg.getClass().getSimpleName(), head, msg.toByteString());
        ctx.writeAndFlush(packageClass);
    }
}
