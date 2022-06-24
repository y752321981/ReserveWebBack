package com.jidai.api.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.jidai.api.common.pojo.entity.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class httpServletResponseJsonWrite {

    public static void writeResult(HttpServletResponse response, Object object) {
        write(response, Result.success(object));
    }

    public static void write(HttpServletResponse response, Object object) {
        try(OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(JSONObject.toJSONString(Result.success(object)).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
