package com.jwjjgs.robotcenter.interceptor;

import com.jwjjgs.robotcenter.common.constant.ResultStatusEnum;
import com.jwjjgs.robotcenter.common.exception.BussinessException;
import com.jwjjgs.robotcenter.pojo.resp.ResponseVo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : tyh
 * @date : 2023/2/9 16:50
 */
@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo<?> throwVaildException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseVo<>(ResultStatusEnum.PARAMS_WARN, methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseVo<?> throwVaildException(BindException bindException) {
        return new ResponseVo<>(ResultStatusEnum.PARAMS_WARN, bindException.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = BussinessException.class)
    @ResponseBody
    public ResponseVo<?> throwVaildException(BussinessException bussinessException) {
        return new ResponseVo<>(bussinessException.getResultStatusEnum());
    }
}
