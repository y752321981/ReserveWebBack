package com.jidai.manager.service;

import com.jidai.api.login.pojo.request.LoginRequest;
import com.jidai.api.login.pojo.response.LoginResponse;

public interface ILoginService {
    LoginResponse signIn(LoginRequest request);
}
