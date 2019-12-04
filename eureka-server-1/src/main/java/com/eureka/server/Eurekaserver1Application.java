package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server 注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver1Application {
    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver1Application.class, args);
    }
}
