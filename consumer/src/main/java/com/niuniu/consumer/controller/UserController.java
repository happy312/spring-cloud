package com.niuniu.consumer.controller;

import com.niuniu.consumer.model.User;
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
    private UserService userServiceProvider;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private com.niuniu.consumer.service.UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return userServiceProvider.hello();
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "type") String type){
        return userLoginService.login(type);
    }

    @RequestMapping("/getById")
    public User getById(@RequestParam(name = "id") Integer id){
        return userService.getById(id);
    }

    @RequestMapping("/updateUser")
    public Integer updateUser(@RequestParam(name = "id") Integer id, @RequestParam(name = "name") String name){
        return userService.updateUser(name, id);
    }
}
