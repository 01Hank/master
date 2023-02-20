package com.jwjjgs.robotcenter.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * @author : tyh
 * @date : 2023/2/1 16:15
 */
@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private              String secret;
    //token过期时间七天
    private static final int    TOKEN_TIME_OUT = 7 * 24 * 3600;

    public String getToken(Map<String, Object> params) {
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .signWith(secretKey) //加密方式
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000)) //过期时间戳
                .addClaims(params)
                .compact();
    }

    public Claims getParams(String token) {
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
        return claimsJws.getBody();
    }
}
