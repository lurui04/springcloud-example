package com.ljmoon.springcloud.redis.service;

import com.ljmoon.springcloud.redis.pojo.UserDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis.service
 * @ClassName: UserService
 * @Description: 用户操作sservice类
 * @Date: 2019-03-14 16:25
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @CachePut(value = "userinfo", condition = "#userDo.age ne 12")
    public UserDo saveUser(UserDo userDo) {
        logger.info("执行数据库保存操作");
        return userDo;
    }

    @Cacheable(value = "userinfo", key = "#userDo.userName")
    public UserDo getUserInfo(UserDo userDo) {
        logger.info("执行数据库查询");
        return userDo;
    }


}
