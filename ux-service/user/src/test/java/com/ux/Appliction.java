package com.ux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: ux
 * @CreateDate: 2020/6/24 11:35
 */
@EnableFeignClients(basePackages = {"com.ux"})      //因为在user模块中使用到了CourseClient
@SpringBootApplication
public class Appliction {
    public static void main(String[] args) {
        SpringApplication.run(Appliction.class, args);
    }
}
