package com.jwjjgs.robotcenter.nettyServer;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;

public class PackageClass extends GeneratedMessageV3 {
    //定义包长
    private int len;

    //协议名字
    private String msgName;

    //包内容
    private Message content;

    public void setLen(int len) {
        this.len = len;
    }

    public void setContent(Message content) {
        this.content = content;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgName() {
        return msgName;
    }

    public int getLen() {
        return len;
    }

    public Message getContent() {
        return content;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return null;
    }

    @Override
    protected Message.Builder newBuilderForType(BuilderParent builderParent) {
        return null;
    }

    @Override
    public Message.Builder newBuilderForType() {
        return null;
    }

    @Override
    public Message.Builder toBuilder() {
        return null;
    }

    @Override
    public Message getDefaultInstanceForType() {
        return null;
    }
}
