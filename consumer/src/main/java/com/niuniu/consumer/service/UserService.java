package com.niuniu.consumer.service;

import com.niuniu.consumer.model.User;

public interface UserService {
    User getById(Integer id);

    Integer updateUser(String name, Integer id);
}
