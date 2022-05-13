package com.jidai.manager.service.impl;

import com.jidai.api.common.utils.JwtUtil;
import com.jidai.api.login.pojo.enums.LoginEnum;
import com.jidai.api.login.pojo.request.LoginRequest;
import com.jidai.api.login.pojo.response.LoginResponse;
import com.jidai.manager.mapper.LoginMapper;
import com.jidai.manager.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private LoginMapper loginMapper;
    @Override
    public LoginResponse signIn(LoginRequest request) {
        if (request == null) {
            return new LoginResponse(LoginEnum.fail);
        }
        Integer accountNumber;
        try {
            accountNumber = this.loginMapper.isAccountExist(request.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse(LoginEnum.fail);
        }
        switch (accountNumber) {
            case 0:
                return new LoginResponse(LoginEnum.accountNotExist);
            case 1:
                String password = this.loginMapper.selectPassword(request.getAccount());
                if (password.equals(request.getPassword())) {
                    return new LoginResponse(LoginEnum.success, JwtUtil.createJwt(request.getAccount(), this.loginMapper.selectName(request.getAccount())));
                } else {
                    return new LoginResponse(LoginEnum.passwordError);
                }
            default:
                return new LoginResponse(LoginEnum.fail);
        }
    }
}
