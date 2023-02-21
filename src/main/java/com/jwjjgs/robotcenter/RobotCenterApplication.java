package com.jwjjgs.robotcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication()
@MapperScan("com.jwjjgs.robotcenter.mapper")
@EnableAspectJAutoProxy
public class RobotCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotCenterApplication.class, args);
    }

}
