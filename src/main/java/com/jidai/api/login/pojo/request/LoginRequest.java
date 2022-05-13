package com.jidai.api.login.pojo.request;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api("登录请求")
public class LoginRequest implements Serializable {
    private String account;
    private String password;
}
