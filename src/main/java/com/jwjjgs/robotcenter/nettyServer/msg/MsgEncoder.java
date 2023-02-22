package com.jwjjgs.robotcenter.nettyServer.msg;

import com.jwjjgs.robotcenter.context.CenterContextAware;
import com.jwjjgs.robotcenter.nettyServer.util.PackageClass;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * -----------------------------------
 * | 协议开始标志 | 包长度|令牌 (定长50个字节)|令牌生成时间(定长50个字节)| 包内容 |
 * -----------------------------------
 * 编码器
 */
@Component
public class MsgEncoder extends MessageToByteEncoder<PackageClass> {
    private static final Logger log = LoggerFactory.getLogger(MsgEncoder.class);
    private CenterContextAware aware = CenterContextAware.getInstance();
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, PackageClass msg, ByteBuf out) throws Exception {
        String simpleName = msg.getMsgName();
        Package.Response.Builder response = Package.Response.newBuilder();
        response.setProtoName(simpleName)
                .setData(msg.getData());
        byte[] bytes = response.build().toByteArray();
        int length = bytes.length;
        //因为包了两层协议数据所以在这里写入包长并生成token
        msg.getPackageHead().setLength(length);
        msg.getPackageHead().setToken(msg.buidToken(aware.getSecretKey()));


        //写入开头标志
        out.writeInt(msg.getPackageHead().getHeadData());
        //包长
        out.writeInt(length);
        //写入token
        byte[] tokenByte = new byte[50];
        byte[] indexByte = msg.getPackageHead().getToken().getBytes();
        try {
            System.arraycopy(indexByte, 0, tokenByte, 0,indexByte.length>tokenByte.length?tokenByte.length:indexByte.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.writeBytes(tokenByte);
        //写入令牌生成时间
        byte[] createTimeByte = new byte[50];
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(msg.getPackageHead().getCreateDate());
        indexByte=time.getBytes();
        System.arraycopy(indexByte, 0, createTimeByte, 0,indexByte.length>createTimeByte.length?createTimeByte.length:indexByte.length);
        out.writeBytes(createTimeByte);

        //response包
        out.writeBytes(bytes);
        log.info("----------encode message:{}, length:{}", simpleName, length);
    }
}
