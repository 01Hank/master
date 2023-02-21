package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.InvalidProtocolBufferException;

public interface BaseHandler {
    void execute() throws InvalidProtocolBufferException;
}
