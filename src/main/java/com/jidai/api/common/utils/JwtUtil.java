package com.jidai.api.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static final String KEY = "userlogin";
    public static final Long FAILURE_TIME = 3600000L;

    public static String createJwt(String id, String username){

        long now = System.currentTimeMillis();
        long exp = now + FAILURE_TIME;
        Date date = new Date(exp);
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(username)
                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,KEY);
        jwtBuilder.setExpiration(date);
        return jwtBuilder.compact();
    }

    public static Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        return claims;
    }

}
