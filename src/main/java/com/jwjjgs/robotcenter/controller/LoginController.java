package com.jwjjgs.robotcenter.controller;

import com.jwjjgs.robotcenter.common.util.JWTUtil;
import com.jwjjgs.robotcenter.pojo.resp.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private JWTUtil jwtUtil;

    @PostMapping("/test")
    public ResponseVo postTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("userId" , "123");
        String token = jwtUtil.getToken(map);
        return new ResponseVo(token);
    }

}
