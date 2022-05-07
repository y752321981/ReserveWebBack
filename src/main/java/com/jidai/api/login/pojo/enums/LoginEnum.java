package com.jidai.api.login.pojo.enums;

import io.swagger.annotations.Api;

@Api("登录结果枚举")
public enum LoginEnum {
    success,
    accountNotExist,
    passwordError
}
