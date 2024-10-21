package com.niuniu.consumer.strategy;

import com.niuniu.consumer.config.LoginTypeConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class LoginFactory implements ApplicationContextAware {

    private static final Map<String, UserLogin> loginPool = new ConcurrentHashMap<>();

    @Autowired
    private LoginTypeConfig loginTypeConfig;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        loginTypeConfig.getTypes().forEach((k, y) -> {
            System.out.println(k + "和" + y);
            loginPool.put(k, (UserLogin) applicationContext.getBean(y));
        });
    }

    /**
     * 对外提供获取具体的策略
     * @param type
     * @return
     */
    public UserLogin getLogin(String type) {
        UserLogin userLogin = loginPool.get(type);
        return userLogin;
    }
}
