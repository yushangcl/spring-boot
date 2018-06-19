package com.whh.spring.boot.controller;

import com.whh.spring.boot.BaseTest;
import com.whh.spring.boot.dao.CmUser;
import org.junit.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author huahui.wu.
 *         Created on 2018/1/26.
 */
public class RedisTest extends BaseTest {

    private static final String CM_USER_REDIS_KEY = "CM_USER_REDIS";

    @Resource
    private HashOperations<String, String, CmUser> hashOperations;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        CmUser cmUser = new CmUser();
        cmUser.setAge(10);
        cmUser.setId(10000L);
        cmUser.setName("TEST_REDIS");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            hashOperations.put(CM_USER_REDIS_KEY, String.valueOf(i), cmUser);
        }
        Long end = System.currentTimeMillis();
        System.out.println("start :" + start);
        System.out.println("end :" + end);
        System.out.println("耗时：" + (end-start));
    }

    @Test
    public void redisTemplateTest() {
        CmUser cmUser = new CmUser();
        cmUser.setAge(10);
        cmUser.setId(10002L);
        cmUser.setName("李四");
        redisTemplate.opsForHash().put("USER_KEY", cmUser.getId(), cmUser);
        CmUser cmUser1 = (CmUser) redisTemplate.opsForHash().get("USER_KEY", cmUser.getId());
        //case 异常
        System.out.println(cmUser1);
    }
}
