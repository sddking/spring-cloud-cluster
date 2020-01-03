package com.springcloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//全局过滤器不需要在配置文件中配置
//TokenFilter需要实现GlobalFilter和Ordered接口，
// 这和实现GatewayFilter很类似。然后根据ServerWebExchange获取ServerHttpRequest，
// 然后根据ServerHttpRequest中是否含有参数token，如果没有则完成请求，终止转发，否则执行正常的逻辑

public class TokenFilter implements GlobalFilter,Ordered {
    Logger logger= LoggerFactory.getLogger( TokenFilter.class );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            logger.info( "token is empty..." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
