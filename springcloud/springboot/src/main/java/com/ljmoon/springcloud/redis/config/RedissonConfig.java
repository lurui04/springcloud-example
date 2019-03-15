package com.ljmoon.springcloud.redis.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.redis.config
 * @ClassName: RedissonConfig
 * @Description: Redis配置类
 * @Date: 2019-03-14 16:17
 */
@Configurable
@EnableCaching
public class RedissonConfig extends CachingConfigurerSupport {


    /**
     * @title: keyGenerator
     * @description: 自定义key生成规则，类名+方法名+参数名（不指定key的情况下）
     * @param: []
     * @return: org.springframework.cache.interceptor.KeyGenerator
     * @date: 2019-03-14 16:20
     * @author: lurui
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                sb.append("test");
                return sb.toString();
            }
        };
    }

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
