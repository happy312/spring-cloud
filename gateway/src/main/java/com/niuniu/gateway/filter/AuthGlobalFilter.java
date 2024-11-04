package com.niuniu.gateway.filter;

import com.niuniu.gateway.config.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1、获取request
        ServerHttpRequest request = exchange.getRequest();
        // 2、判断是否需要做登录拦截
        if (isExclude(request.getPath().toString())) {
            // 放行
            return chain.filter(exchange);
        }
        // 3、获取token
        String token = null;
        List<String> heads = request.getHeaders().get("authorization");
        if (heads != null && !heads.isEmpty()) {
            token = heads.get(0);
        }
        // 4、校验并解析token

        // 5、传递用户信息 todo

        // 6、放行

        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Boolean isExclude(String path) {
        return true;
    }
}
