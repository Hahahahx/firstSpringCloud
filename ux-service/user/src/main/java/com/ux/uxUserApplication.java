package com.ux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Springboot 启动入口
 *
 * @Author: ux
 * @CreateDate: 2020/6/22 16:43
 */
@EnableJpaAuditing
@EnableFeignClients //通过Feign去调用微服务
@EnableCircuitBreaker   //通过Hystrix实现服务熔断
@EnableEurekaClient
@SpringBootApplication
public class uxUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(uxUserApplication.class, args);
    }
}
