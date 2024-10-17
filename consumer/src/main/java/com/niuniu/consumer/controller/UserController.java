package com.niuniu.consumer.controller;

import com.niuniu.provider.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return userService.hello();
    }
}
