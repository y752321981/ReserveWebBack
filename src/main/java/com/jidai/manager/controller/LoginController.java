package com.jidai.manager.controller;

import com.jidai.api.common.pojo.entity.Result;
import com.jidai.api.login.pojo.request.LoginRequest;
import com.jidai.api.login.pojo.response.LoginResponse;
import com.jidai.manager.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    private Result<LoginResponse> signIn(LoginRequest request) {
        return Result.success(this.loginService.signIn(request));
    }
}
