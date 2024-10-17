package com.niuniu.provider.service.impl;

import com.niuniu.provider.service.UserService;
import org.apache.dubbo.config.annotation.Service;

// 使用dubbo下的注解
@Service(version = "1.0.0", timeout = 50000)
public class UserServiceImpl implements UserService {
    @Override
    public String hello() {
        return "你好，我是provider";
    }
}
