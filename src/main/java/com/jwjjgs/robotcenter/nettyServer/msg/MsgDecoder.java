package com.jwjjgs.robotcenter.nettyServer.msg;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MsgDecoder extends ByteToMessageDecoder{
    private static final Logger log = LoggerFactory.getLogger(MsgDecoder.class);

    private static CenterContextAware aware = CenterContextAware.getInstance();


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("MsgDecoder decode length:{}", in.readableBytes());

        //标记一下当前下标
        in.markReaderIndex();
        if (in.readableBytes() < 2){
            return;
        }

        int length = in.readShort();
        int version = in.readInt();
        if (length < 0 || version != this.aware.getVersion()){
            //非法数据, 关闭连接
            ctx.close();
        }

        if (length > in.readableBytes()){
            //长度不对不读
            in.resetReaderIndex();
            return;
        }

        byte[] array;
        if(in.hasArray()){
            ByteBuf slice = in.slice();
            array = slice.array();
        }else {
            array = new byte[length];
            in.readBytes(array, 0, length);
        }

        Package.Request request = Package.Request.parseFrom(array);
        String protoName = request.getProtoName();
        ByteString data = request.getData();
        Class<? extends Message> clzz = aware.getProtoClass(protoName);
        if (clzz == null){
            log.error("-------client error protoName:{}", protoName);
            return;
        }

        //封装成package类
        PackageClass aClass = new PackageClass();
        aClass.setLen(length);
        aClass.setMsgName(request.getProtoName());
        aClass.setData(data.toByteArray());

        out.add(aClass);
    }
}
