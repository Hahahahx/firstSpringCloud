package com.ux;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关应用程序
 * Create by ux
 */
@EnableZuulProxy        //标识档期那应用是zuul server 网关服务器
@SpringCloudApplication     //简化配置组合注解，可以点进去看看，最后还是SpringBootApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
