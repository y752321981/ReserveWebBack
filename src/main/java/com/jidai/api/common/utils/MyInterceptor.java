package com.jidai.api.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.jidai.api.common.pojo.entity.Result;
import com.jidai.api.common.pojo.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenCache tokenCache;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String, String> result = new HashMap<>();
        if (token == null || "".equals(token)) {
            result.put("code", ResultEnum.NULL_TOKEN.getCode());
            result.put("msg", ResultEnum.NULL_TOKEN.getMessage());

            return false;
        }

        return tokenCache.checkToken(token, response);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
