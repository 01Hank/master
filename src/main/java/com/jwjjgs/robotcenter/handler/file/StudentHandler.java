package com.jwjjgs.robotcenter.handler.file;

import com.google.protobuf.InvalidProtocolBufferException;
import com.jwjjgs.robotcenter.common.annotation.MsgHandler;
import com.jwjjgs.robotcenter.handler.BaseHandlerImpl;
import com.jwjjgs.robotcenter.nettyServer.PackageClass;
import com.jwjjgs.robotcenter.pojo.protoFile.Msg;
import com.jwjjgs.robotcenter.pojo.protoFile.Package;
import org.springframework.stereotype.Component;

@Component
@MsgHandler(clzz = Msg.Student.class)
public class StudentHandler extends BaseHandlerImpl<PackageClass> {
    @Override
    public void execute(PackageClass packge) throws InvalidProtocolBufferException {
        Msg.Student builder = (Msg.Student)packge.getContent();
        String name = builder.getName();
        int age = builder.getAge();

        Package.ConnectSuc.Builder ret = Package.ConnectSuc.newBuilder();
        ret.setOk(1).build();
        sendMsg(ret);
    }
}
