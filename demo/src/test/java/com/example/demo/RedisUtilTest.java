package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.redis.RedisUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    @Resource
    private RedisTemplate<String,String>redisTemplate;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

}
