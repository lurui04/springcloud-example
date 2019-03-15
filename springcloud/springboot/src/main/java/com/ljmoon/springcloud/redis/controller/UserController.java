package com.ljmoon.springcloud.redis.controller;

import com.ljmoon.springcloud.redis.pojo.UserDo;
import com.ljmoon.springcloud.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis.controller
 * @ClassName: UserController
 * @Description: 测试controlle
 * @Date: 2019-03-15 14:05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping
    public String userTest() {
        UserDo userDo = new UserDo("123456", "123", "1", 20, "北京");
        this.userService.saveUser(userDo);
        return "SCUESS";
    }

}
