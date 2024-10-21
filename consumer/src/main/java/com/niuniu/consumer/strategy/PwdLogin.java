package com.niuniu.consumer.strategy;

import org.springframework.stereotype.Component;

@Component
public class PwdLogin implements UserLogin{
    @Override
    public String login() {
        return "登录成功，登录方式是账号密码登录";
    }
}
