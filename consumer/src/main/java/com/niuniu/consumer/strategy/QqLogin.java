package com.niuniu.consumer.strategy;

import org.springframework.stereotype.Component;

@Component
public class QqLogin implements UserLogin{
    @Override
    public String login() {
        return "登录成功，登录方式是QQ登录";
    }
}
