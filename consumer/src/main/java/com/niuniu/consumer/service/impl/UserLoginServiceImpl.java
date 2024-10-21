package com.niuniu.consumer.service.impl;

import com.niuniu.consumer.service.UserLoginService;
import com.niuniu.consumer.strategy.LoginFactory;
import com.niuniu.consumer.strategy.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private LoginFactory loginFactory;

    @Override
    public String login(String type) {
        UserLogin userLogin = loginFactory.getLogin(type);
        if (userLogin == null) {
            return "登录失败，未知的登录方式。";
        }

        String result = userLogin.login();
        return result;
    }
}
