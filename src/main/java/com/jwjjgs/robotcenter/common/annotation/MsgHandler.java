package com.jwjjgs.robotcenter.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MsgHandler {
    Class clzz();
}