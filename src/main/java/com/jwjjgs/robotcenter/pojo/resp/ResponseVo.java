package com.jwjjgs.robotcenter.pojo.resp;

import com.jwjjgs.robotcenter.common.constant.ResultStatusEnum;

/**
 * 返回对象
 *
 * @author lWX455828
 * @version 2020-11-26
 * @since PKP-LMAV7.01.00
 */
public class ResponseVo<T> {
    /**
     * 返回描述
     */
    private String msg;

    /**
     * 返回码
     */
    private String status;

    /**
     * 返回数据对象
     */
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseVo() {
        this.msg = ResultStatusEnum.SUCCESS.getMsg();
        this.status = ResultStatusEnum.SUCCESS.getStatus();
    }

    public ResponseVo(ResultStatusEnum r) {
        this.msg = r.getMsg();
        this.status = r.getStatus();
    }

    public ResponseVo(ResultStatusEnum r, String msg) {
        this.msg = String.format(r.getMsg(), msg);
        this.status = r.getStatus();
    }

    public ResponseVo(T data) {
        this();
        this.data = data;
    }

    public ResponseVo(ResultStatusEnum r, T data) {
        this(r);
        this.data = data;
    }

    public ResponseVo(T data, ResultStatusEnum r) {
        this(r);
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo [data=" + data + ", msg="
               + msg + ", status=" + status + "]";
    }
}
