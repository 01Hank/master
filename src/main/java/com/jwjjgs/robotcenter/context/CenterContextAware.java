package com.jwjjgs.robotcenter.context;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.common.annotation.MsgHandler;
import com.jwjjgs.robotcenter.handler.BaseHandler;
import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import com.jwjjgs.robotcenter.nettyServer.ser.ProtostuffSerializeI;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CenterContextAware implements ApplicationContextAware, CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CenterContextAware.class);

    @Autowired
    private ProtostuffSerializeI serializeI;

    private  ApplicationContext context = null;

    //handler工厂
    private  Map<String, Class<? extends BaseHandler>> factory = new HashMap<>();

    //msg工厂
    private  Map<String, Class<? extends Message>> msgFactory = new HashMap<>();

    //所有连接
    private  Map<String, ChannelHandlerContext> ctxs = new HashMap<>();


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void run(String... args) {
        this.initMsgHandler();
    }

    /**
     * 获取bean
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public  <T> T getBean(Class<T> tClass) {
        Class bean = context.getBean(tClass.getClass());
        return (T) bean;
    }


    /**
     * 初始化工厂
     */
    public  void initMsgHandler() {
        Map<String, BaseHandler> beansOfType = context.getBeansOfType(BaseHandler.class);
        for (BaseHandler<GeneratedMessageV3> handler : beansOfType.values()) {
            Class<? extends BaseHandler<GeneratedMessageV3>> aClass = (Class<? extends BaseHandler<GeneratedMessageV3>>) handler.getClass();
            MsgHandler msg = aClass.getAnnotation(MsgHandler.class);
            if (msg != null) {
                String simpleName = msg.clzz().getSimpleName();
                factory.put(simpleName, aClass);
                msgFactory.put(simpleName, msg.clzz());
            }
        }

        log.info("-----------handler,meg工厂初始化完成, \nkeys:\n{}\nfactory:\n{}\nmsgFactory:\n{}", this.factory.keySet(), this.factory.values(), this.msgFactory.values());
    }

    /**
     * 创建handler
     *
     * @param simpleName
     * @return
     */
    public BaseHandlerImpl<PackageClass> createHandler(String simpleName) throws IllegalAccessException, InstantiationException {
        Class aClass = factory.get(simpleName);
        return (BaseHandlerImpl<PackageClass>) aClass.newInstance();
    }

    /**
     * 加载proto类
     * @param protoName
     * @return
     * @throws ClassNotFoundException
     */
    public  Message loadProto(String protoName, byte[] data) throws InstantiationException, IllegalAccessException {
        Class<? extends Message> clzz = msgFactory.get(protoName);
        return this.serializeI.deserialize(data, clzz);
    }

    /**
     * 获取某个地址的连接
     * @param address
     * @return
     */
    public ChannelHandlerContext getCtx(String address){
        return this.ctxs.get(address);
    }

    /**
     * 新增一个连接
     * @param address
     * @param ctx
     * @return
     */
    public void putCtx(String address, ChannelHandlerContext ctx){
        this.ctxs.put(address, ctx);
    }
    /**
     * 移除某个连接
     * @param address
     */
    public void delCtx(String address){
        this.ctxs.remove(address);
    }

    /**
     * 通知所有连接
     * @param msg
     */
    public void notifyAll(Message.Builder msg){
        for(Map.Entry<String, ChannelHandlerContext> entry:this.ctxs.entrySet()){
            entry.getValue().writeAndFlush(msg);
        }
    }
}
