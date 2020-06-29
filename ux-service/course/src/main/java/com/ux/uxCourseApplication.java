package com.ux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Springboot启动入口
 *
 * @Author: ux
 * @CreateDate: 2020/6/8 8:15
 */
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class uxCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(uxCourseApplication.class, args);
    }
}
