package com.jwjjgs.robotcenter.nettyServer.util;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;

/**
 * 包数据格式
 */
public class PackageClass extends GeneratedMessageV3 {
    //包头
    private PackageHead packageHead;

    //协议名字
    private String msgName;

    //包内容
    private ByteString data;

    public PackageClass(String msgName, PackageHead packageHead, ByteString data) {
        this.packageHead = packageHead;
        this.msgName = msgName;
        this.data = data;
    }

    public PackageHead getPackageHead() {
        return packageHead;
    }

    public void setPackageHead(PackageHead packageHead) {
        this.packageHead = packageHead;
    }
    public ByteString getData() {
        return data;
    }

    public void setData(ByteString data) {
        this.data = data;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgName() {
        return msgName;
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

    /**
     * 生成token   协议开始标志 +包长度+令牌生成时间+包内容+服务器与客户端约定的秘钥
     * @return
     */
    public String buidToken(String secretKey) {
        //生成token
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(this.getPackageHead().getCreateDate());// 这个就是把时间戳经过处理得到期望格式的时间
        String allData=String.valueOf(this.getPackageHead().getHeadData());
        allData+=String.valueOf(this.getPackageHead().getLength());
        allData+=time;
        allData+=new String(this.getData().toByteArray());
        allData+=secretKey;//秘钥
        return DigestUtils.md5DigestAsHex(allData.getBytes());
    }
    /**
     * 验证是否认证通过
     * @param token
     * @return
     */
    public boolean authorization(String token) {
        //表示参数被修改
        if(!token.equals(this.getPackageHead().getToken())) {
            return false;
        }
        //验证是否失效
        Long s = (System.currentTimeMillis() - this.getPackageHead().getCreateDate().getTime()) / (1000 * 60);
        if(s>60) {
            return false;
        }
        return true;
    }
}
