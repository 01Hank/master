package com.jwjjgs.robotcenter.config;

import com.jwjjgs.robotcenter.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : tyh
 * @date : 2023/2/14 10:26
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登陆拦截 需要 通过属性注入来获取有loginIntercept拦截器对象执行拦截方法
        // addPathPatterns 是拦截方法
        // excludePathPatterns 不拦截方法是
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") //拦截所有 的url
                .excludePathPatterns("/login/*");  //不拦截登录
//                .excludePathPatterns("/**");  //不拦截登录
    }
}
