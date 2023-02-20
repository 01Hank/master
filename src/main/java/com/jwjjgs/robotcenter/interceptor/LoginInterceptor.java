package com.jwjjgs.robotcenter.interceptor;

import com.jwjjgs.robotcenter.common.constant.ResultStatusEnum;
import com.jwjjgs.robotcenter.common.exception.BussinessException;
import com.jwjjgs.robotcenter.common.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : tyh
 * @date : 2023/2/13 17:31
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new BussinessException(ResultStatusEnum.LOGIN_WARN);
        }
        try {
            Claims params = jwtUtil.getParams(token);
            String userId = params.get("userId").toString();
            request.getSession().setAttribute("userId", userId);
        } catch (Exception e) {
            throw new BussinessException(ResultStatusEnum.TOKEN_WARN);
        }
        return true;
    }
}
