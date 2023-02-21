package com.jwjjgs.robotcenter.handler.file;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.jwjjgs.robotcenter.common.annotation.MsgHandler;
import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@MsgHandler(clzz = Msg.Student.class)
public class StudentHandler extends BaseHandlerImpl<Msg.Student> {
    @Override
    public void execute() throws InvalidProtocolBufferException {
        Msg.Student builder = getMsg();
        String name = builder.getName();
        int age = builder.getAge();

        Package.ConnectSuc.Builder ret = Package.ConnectSuc.newBuilder();
        ret.setOk(1);
        sendMsg(ret.build());
    }

    @Override
    public Msg.Student deserialize(byte[] data) throws IOException {
        return Msg.Student.parseFrom(data);
    }
}
