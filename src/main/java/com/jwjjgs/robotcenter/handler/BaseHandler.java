package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public interface BaseHandler {
    void execute() throws InvalidProtocolBufferException;
}
