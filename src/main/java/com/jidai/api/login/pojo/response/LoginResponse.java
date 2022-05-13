package com.jidai.api.login.pojo.response;

import com.jidai.api.login.pojo.enums.LoginEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api("登录结果响应")
public class LoginResponse implements Serializable {
    @ApiModelProperty("登录结果")
    private Integer status;

    @ApiModelProperty("token")
    private String token;

    public LoginResponse(LoginEnum loginEnum) {
        this(loginEnum, null);
    }

    public LoginResponse(LoginEnum loginEnum, String token) {
        status = loginEnum.ordinal();
        this.token = token;
    }
}
