package com.cmct.base.util;

import com.cmct.common.web.WebResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import java.util.Date;

import static com.cmct.base.exception.CmctError.TOKEN_ERROR;
import static com.cmct.base.exception.CmctError.TOKEN_EXPIRED;

public class TokenUtil {

    public static WebResponse tokenValidate(String requestHeader, String secret) {
        String authToken;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = isTokenExpired(secret, authToken);
                if (flag) {
                    return WebResponse.builder()
                            .code(TOKEN_EXPIRED.getCode())
                            .msg(TOKEN_EXPIRED.getDesc())
                            .build();
                }
                return null;
            } catch (JwtException e) {
                //有异常就是token解析失败
                return WebResponse.builder()
                        .code(TOKEN_ERROR.getCode())
                        .msg(TOKEN_ERROR.getDesc())
                        .build();
            }
        }
        //header没有带Bearer字段
        return WebResponse.builder()
                .code(TOKEN_ERROR.getCode())
                .msg(TOKEN_ERROR.getDesc())
                .build();
    }

    public static Boolean isTokenExpired(String secret, String token) {
        try {
            final Date expiration = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }
}
