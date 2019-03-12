package com.ljmoon.springcloud.redis;

import com.ljmoon.springcloud.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis
 * @ClassName: RedisTest
 * @Description: Redis测试类
 * @Date: 2019-03-12 10:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void redisSetTest() {
        redisService.addValue("name", "lurui");
    }


}
