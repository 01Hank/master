package com.jwjjgs.robotcenter.nettyServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // decoded
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024 * 4, 0, 4, 0, 4));
        //解码客户端发过来的消息
        ch.pipeline().addLast(new ProtobufDecoder(Msg.Student.getDefaultInstance()));
        // encoded
        ch.pipeline().addLast(new LengthFieldPrepender(4));
        ch.pipeline().addLast(new ProtobufEncoder());
        // 注册handler
        ch.pipeline().addLast(new ServerHandler());
    }
}
