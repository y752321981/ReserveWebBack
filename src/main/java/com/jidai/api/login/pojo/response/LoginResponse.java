package com.jidai.api.login.pojo.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
