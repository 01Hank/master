package com.jwjjgs.robotcenter.nettyServer.msg;

import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 编码器
 */
@Component
public class MsgEncoder extends MessageToByteEncoder<Message> {
    private static final Logger log = LoggerFactory.getLogger(MsgEncoder.class);
    private CenterContextAware aware = CenterContextAware.getInstance();
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message msg, ByteBuf out) throws Exception {
        String simpleName = msg.getClass().getSimpleName();
        Package.Response.Builder response = Package.Response.newBuilder();
        response.setProtoName(simpleName)
                .setData(msg.toByteString());

        byte[] bytes = response.build().toByteArray();
        int lenght   = bytes.length;

        //包长
        out.writeShort(lenght);
        //版本号
        out.writeInt(aware.getVersion());
        //response包
        out.writeBytes(bytes);
        log.info("----------encode message:{}", simpleName);
    }
}
