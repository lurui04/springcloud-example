package com.ljmoon.springcloud.redis;

import com.ljmoon.springcloud.Application;
import com.ljmoon.springcloud.redis.config.RedissonConfig;
import com.ljmoon.springcloud.redis.pojo.UserDo;
import com.ljmoon.springcloud.redis.service.RedisService;
import com.ljmoon.springcloud.redis.service.UserService;
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
/**
 * 这里配置类（配置文件）需要显示指定，需要哪些配置就指定哪些配置
 * https://blog.csdn.net/jiangyu1013/article/details/80336799
 */
@SpringBootTest(classes = {Application.class, RedissonConfig.class})
public class RedisTest {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;

    @Test
    public void redisSetTest() {
        redisService.addValue("name", "123");
    }

    @Test
    public void userSaveTest() {
        UserDo userDo = new UserDo("123456789", "123", "1", 20, "北京");
        UserDo result = userService.saveUser(userDo);
        System.out.println(result.toString());
    }

    @Test
    public void getUserInfo() {
        UserDo userDo = new UserDo("lurui", "123", "1", 20, "北京");
        UserDo result = userService.getUserInfo(userDo);
        System.out.println(result.toString());
    }


}
