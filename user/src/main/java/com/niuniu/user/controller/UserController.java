package com.niuniu.user.controller;

import com.niuniu.user.mapper.UserMapper;
import com.niuniu.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 手写负载均衡
     * 调用user-service
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello，这里是user-service";
    }

    @GetMapping("/queryOrderByIds")
    public List<User> queryOrderByIds(@RequestParam(name = "ids") List<String> ids){

        return Collections.emptyList();
    }
}
