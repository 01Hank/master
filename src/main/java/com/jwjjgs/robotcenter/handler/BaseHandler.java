package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import io.netty.channel.ChannelHandlerContext;

public interface BaseHandler<S extends GeneratedMessageV3> {
    void execute(PackageClass packge) throws InvalidProtocolBufferException;
}
