package com.niuniu.gateway.util;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

public class JwtTool {
    public Long parseToken(String token) {
        // 校验token是否为空
        if (token == null) {
            throw new RuntimeException("未登录");
        }
        // 校验并解析jwt
        OAuth2ResourceServerProperties.Jwt jwt;

        return null;

    }
}
