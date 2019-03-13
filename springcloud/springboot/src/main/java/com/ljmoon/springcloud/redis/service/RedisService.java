package com.ljmoon.springcloud.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis.service
 * @ClassName: RedisService
 * @Description: redis操作类
 * @Date: 2019-03-12 10:12
 */
@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addValue(String key, String value) {
        logger.info("redis set test!!!");
        this.redisTemplate.opsForValue().set(key, value);
    }

}
