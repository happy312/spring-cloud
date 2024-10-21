package com.niuniu.consumer.strategy;

import org.springframework.stereotype.Component;

@Component
public class WeixinLogin implements UserLogin{
    @Override
    public String login() {
        return "登录成功，登录方式是微信登录";
    }
}
