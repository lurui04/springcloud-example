package com.ljmoon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Package: com.ljmoon.springcloud
 * @ClassName: Application
 * @Description:
 * @author: lurui
 * @Date: 2018/3/28 下午10:06
 * @version:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
