package com.jwjjgs.robotcenter.controller;

import com.jwjjgs.robotcenter.common.constant.ResultStatusEnum;
import com.jwjjgs.robotcenter.pojo.req.DemoReq;
import com.jwjjgs.robotcenter.pojo.resp.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : tyh
 * @date : 2023/2/20 10:56
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    
    @GetMapping("/test")
    public ResponseVo getTest(@Valid DemoReq demoReq){
        return new ResponseVo(ResultStatusEnum.SUCCESS);
    }

    @PostMapping("/test")
    public ResponseVo postTest(@Valid @RequestBody DemoReq demoReq){

        return new ResponseVo(ResultStatusEnum.SUCCESS);
    }
}
