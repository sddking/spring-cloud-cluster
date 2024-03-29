package com.springcloud.gateway.resolve;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//根据uri去限流，这时KeyResolver代码
public class UriKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange
                .getRequest()
                .getURI()
                .getPath()
        );
    }

    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }
}
