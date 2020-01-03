package com.springcloud.gateway;

import com.springcloud.gateway.filter.RequestTimeGatewayFilterFactory;
import com.springcloud.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    //需要在工程的启动文件Application类中，
    //向Srping Ioc容器注册RequestTimeGatewayFilterFactory类的Bean
    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    //TokenFilter在工程的启动类中注入到Spring Ioc容器中
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    //也可以以用户的维度去限流
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

}
