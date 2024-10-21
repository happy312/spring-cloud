package com.niuniu.consumer.controller;

import com.niuniu.consumer.service.UserLoginService;
import com.niuniu.provider.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/hello")
    public String hello(){
        return userService.hello();
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "type") String type){
        return userLoginService.login(type);
    }
}
