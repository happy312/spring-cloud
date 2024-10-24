package com.niuniu.consumer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niuniu.consumer.mapper.UserMapper;
import com.niuniu.consumer.model.User;
import com.niuniu.consumer.service.UserService;
import com.niuniu.consumer.utils.RedisUtil;
import io.lettuce.core.RedisClient;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 使用读锁
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock("read_write_lock_test1");
        RLock readLock = rReadWriteLock.readLock();
        try {
            readLock.lock();
            String key = String.valueOf(id);
            String result = redisTemplate.opsForValue().get(key);
            if (StringUtil.isEmpty(result)) {
                User user = userMapper.getById(id);
                redisTemplate.opsForValue().set(key, JSONObject.toJSONString(user));
                return user;
            }
            return JSONObject.parseObject(result, User.class);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 使用写锁
     * @param name
     * @param id
     * @return
     */
    @Override
    public Integer updateUser(String name, Integer id) {
        RReadWriteLock rReadWriteLock = redissonClient.getReadWriteLock("read_write_lock_test1");
        RLock writeLock = rReadWriteLock.writeLock();
        Integer result;
        System.out.println("111999888");
        try {
            writeLock.lock();
            result = userMapper.update(name, id);
            if (result > 0) {
                User user = userMapper.getById(id);
                redisTemplate.opsForValue().set(String.valueOf(id), JSONObject.toJSONString(user));
            }
        } finally {
            writeLock.unlock();
        }
        return result;
    }
}
