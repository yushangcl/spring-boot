package com.whh.spring.boot.controller;

import com.whh.spring.boot.BaseTest;
import com.whh.spring.boot.dao.CmUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


/**
 * @author huahui.wu.
 * Created on 2018/4/10.
 */
public class MongoDBTest extends BaseTest{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() {
        CmUser cmUser = new CmUser();
        cmUser.setId(1L);
        cmUser.setName("李四");
        mongoTemplate.insert(cmUser);
    }
}
