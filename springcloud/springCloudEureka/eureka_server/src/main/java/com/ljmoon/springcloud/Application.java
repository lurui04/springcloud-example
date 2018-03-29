package com.ljmoon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Package: com.ljmoon.springcloud
 * @ClassName: Application
 * @Description: 服务注册中心
 * @author: lurui
 * @Date: 2018/3/28 下午10:06
 * @version:
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
