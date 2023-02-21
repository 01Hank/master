package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jwjjgs.robotcenter.common.handler.MsgInfo;

public interface BaseHandler<S extends GeneratedMessageV3> {
    void execute(MsgInfo msgInfo) throws InvalidProtocolBufferException;
}
