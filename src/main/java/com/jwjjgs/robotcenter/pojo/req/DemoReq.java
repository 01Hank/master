package com.jwjjgs.robotcenter.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : tyh
 * @date : 2023/2/20 10:54
 */
@Data
public class DemoReq {

    @NotBlank(message = "请填写姓名jwjjgs")
    private String name;
}
