package com.jwjjgs.robotcenter.handler;

import com.google.protobuf.InvalidProtocolBufferException;
import com.jwjjgs.robotcenter.common.annotation.MsgHandler;
import com.jwjjgs.robotcenter.common.handler.MsgInfo;
import org.springframework.stereotype.Component;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;

@Component
@MsgHandler(clzz = Msg.Student.class)
public class TestHandler implements BaseHandler<Msg.Student> {
    @Override
    public void execute(MsgInfo msgInfo) throws InvalidProtocolBufferException {

    }
}
