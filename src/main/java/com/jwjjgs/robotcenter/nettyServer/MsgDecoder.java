package com.jwjjgs.robotcenter.nettyServer;

import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MsgDecoder extends ByteToMessageDecoder{
    private static final Logger log = LoggerFactory.getLogger(MsgDecoder.class);

    @Autowired
    private CenterContextAware aware;

    private int length = 0;
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        log.info("MsgDecoder decode length:{}", in.readableBytes());
        if(in.readableBytes() >= 4){
            if(length == 0){
                length = in.readInt();
            }

            if(in.readableBytes() < length){
                log.info("MsgDecoder decode data length is not enough, wait!!");
            }

            byte[] content = new byte[length];
            if(in.readableBytes() >= length){
                in.readBytes(content);

                try {
                    Package.Request request = (Package.Request)aware.loadProto("Request", content);
                    String protoName = request.getProtoName();//拿到proto名字
                    byte[] bytes = request.getContent().toByteArray();//拿到proto数据

                    //拿到实例注入数据
                    Message message1 = aware.loadProto(protoName, bytes);

                    //封装成package类
                    PackageClass aClass = new PackageClass();
                    aClass.setLen(length);
                    aClass.setContent(message1);
                    aClass.setMsgName(request.getProtoName());
                    out.add(aClass);
                }catch (Exception e){
                    log.error("---------proto read data error!!!");
                }
            }

            length = 0;
        }
    }
}
