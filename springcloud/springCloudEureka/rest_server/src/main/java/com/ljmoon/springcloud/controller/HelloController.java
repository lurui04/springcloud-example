package com.ljmoon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.ljmoon.springcloud.controller
 * @ClassName: HelloController
 * @Description: 一个普通的rest接口
 * @author: lurui
 * @Date: 2018/3/28 下午10:46
 * @version:
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        client.getLocalServiceInstance();
        return "hello word";
    }
}
