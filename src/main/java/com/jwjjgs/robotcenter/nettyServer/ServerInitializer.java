package com.jwjjgs.robotcenter.nettyServer;

import com.jwjjgs.robotcenter.nettyServer.msg.MsgDecoder;
import com.jwjjgs.robotcenter.nettyServer.msg.MsgEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // decoded
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024 * 4, 0, 4, 0, 4));
        //解码客户端发过来的消息
        ch.pipeline().addLast("decoder", new MsgDecoder());
        // encoded
        ch.pipeline().addLast(new LengthFieldPrepender(4));
        ch.pipeline().addLast("encoder", new MsgEncoder());
        // 注册handler
        ch.pipeline().addLast(new ServerHandler());
    }
}
