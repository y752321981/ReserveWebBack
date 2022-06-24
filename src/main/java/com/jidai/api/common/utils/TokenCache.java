package com.jidai.api.common.utils;

import com.jidai.api.common.pojo.entity.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenCache {
    private final RedisTemplate redisTemplate;
    private final String TOKEN_PREFIX = "user:token:";
    private final Integer EXCEED_HOUR = 1;
    private final Integer EXCEED_MIN = 1;
    private final Integer EXCEED_SEC = 1;

    /**
     * 新增token
     * @param token
     */
    public void addToken(Token token) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, EXCEED_HOUR);
        instance.add(Calendar.MINUTE, EXCEED_MIN);
        instance.add(Calendar.SECOND, EXCEED_SEC);
        token.setExceedDate(instance.getTime());
        redisTemplate.opsForHash().putIfAbsent(TOKEN_PREFIX, token.getToken(), token);
    }

    /**
     * 判断token是否有效
     * @param token
     * @param response
     * @return
     */
    public Boolean checkToken(String token, HttpServletResponse response) {
        Token t =(Token) redisTemplate.opsForHash().get(TOKEN_PREFIX, token);
        Map<String, String> result = new HashMap<>();
        if (t == null) {

            return false;
        }
        boolean isAfter = t.getExceedDate().after(new Date());
        if (!isAfter) {
            redisTemplate.opsForHash().delete(TOKEN_PREFIX, token);
        }
        return isAfter;
    }
}
