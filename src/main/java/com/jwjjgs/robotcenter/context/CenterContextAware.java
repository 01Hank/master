package com.jwjjgs.robotcenter.context;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.common.annotation.MsgHandler;
import com.jwjjgs.robotcenter.handler.BaseHandler;
import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CenterContextAware implements ApplicationContextAware, CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CenterContextAware.class);

    @Value("${version}")
    private Integer version = 1;

    private static   ApplicationContext context = null;

    //handler工厂
    private static   Map<String, Class<? extends BaseHandler>> factory = new HashMap<>();

    //msg工厂
    private static   Map<String, Class<? extends Message>> msgFactory = new HashMap<>();

    //所有连接
    private static   Map<String, ChannelHandlerContext> ctxs = new HashMap<>();

    private CenterContextAware(){}

    private static CenterContextAware awar = null;

    public static CenterContextAware getInstance(){
        if (awar == null) {
            awar = new CenterContextAware();
        }

        return awar;
    }

    public Integer getVersion() {
        return version;
    }


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
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }


    /**
     * 初始化工厂
     */
    public  void initMsgHandler() {
        Map<String, BaseHandler> beansOfType = context.getBeansOfType(BaseHandler.class);
        for (BaseHandler handler : beansOfType.values()) {
            Class<? extends BaseHandler> aClass =  handler.getClass();
            MsgHandler msg = aClass.getAnnotation(MsgHandler.class);
            if (msg != null) {
                String simpleName = msg.clzz().getSimpleName();
                factory.put(simpleName, aClass);
                msgFactory.put(simpleName, msg.clzz());
            }
        }

        log.error("-----------handler,meg工厂初始化完成, \nkeys:\n{}\nfactory:\n{}\nmsgFactory:\n{}", this.factory.keySet(), this.factory.values(), this.msgFactory.values());
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
    public  Class<? extends Message> getProtoClass(String protoName) throws InstantiationException, IllegalAccessException {
        return this.msgFactory.get(protoName);
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
