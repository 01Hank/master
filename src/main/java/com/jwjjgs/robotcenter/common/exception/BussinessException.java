package com.jwjjgs.robotcenter.common.exception;

import com.jwjjgs.robotcenter.common.constant.ResultStatusEnum;

/**
 * @author : tyh
 * @date : 2023/2/14 10:40
 */
public class BussinessException extends Exception {
    private ResultStatusEnum r;

    private BussinessException() {
        super();
    }

    public BussinessException(ResultStatusEnum resultStatusEnum) {
        this.r = resultStatusEnum;
    }

    public ResultStatusEnum getResultStatusEnum() {
        return r;
    }
}
