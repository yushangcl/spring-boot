package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.BaseTest;
import com.whh.spring.boot.service.CmUserService;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
public class CmUserServiceImplTest extends BaseTest{

    @Resource
    private CmUserService cmUserService;
    @Test
    public void setUserToRedis() throws Exception {
        cmUserService.setUserToRedis("张三");

    }

}