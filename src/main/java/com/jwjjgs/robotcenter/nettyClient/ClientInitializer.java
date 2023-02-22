package com.jwjjgs.robotcenter.nettyClient;


import com.jwjjgs.robotcenter.nettyClient.Handler.ClientHandler;
import com.jwjjgs.robotcenter.nettyServer.msg.MsgDecoder;
import com.jwjjgs.robotcenter.nettyServer.msg.MsgEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // decoded
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
        //这里是收到服务端发过来的消息,所以是对服务端的response解码
        ch.pipeline().addLast("decoder", new MsgDecoder());
        // encoded
        ch.pipeline().addLast(new LengthFieldPrepender(4));
        ch.pipeline().addLast("encoder", new MsgEncoder());
        // 注册handler
        ch.pipeline().addLast(new ClientHandler());
    }

}
