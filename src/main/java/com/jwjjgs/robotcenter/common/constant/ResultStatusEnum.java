package com.jwjjgs.robotcenter.common.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : tyh
 * @date : 2023/2/7 15:58
 */
public enum ResultStatusEnum {
    SUCCESS("000000", "success"),
    FAIL("000001", "业务错误"),
    TOKEN_WARN("000002", "token解析异常，请重新登录"),
    LOGIN_WARN("000003", "未登录，请登录"),
    PARAMS_WARN("000004", "参数异常:%s");

    private String msg;

    private String status;

    ResultStatusEnum(String status, String msg) {
        this.msg = msg;
        this.status = status;
    }

    public static ResultStatusEnum getEnumByCode(String code) {
        for (ResultStatusEnum resultStatusEnum : ResultStatusEnum.values()) {
            if (StringUtils.equals(code, resultStatusEnum.getStatus())) {
                return resultStatusEnum;
            }
        }
        return null;
    }

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
}
