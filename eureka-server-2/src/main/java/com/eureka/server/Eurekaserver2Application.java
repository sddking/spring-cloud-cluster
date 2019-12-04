package com.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server 注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver2Application {
    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver2Application.class, args);
    }
}
