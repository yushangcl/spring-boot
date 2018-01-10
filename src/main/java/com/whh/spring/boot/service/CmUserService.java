package com.whh.spring.boot.service;

import com.whh.spring.boot.dao.CmUser;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
public interface CmUserService {

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    CmUser getUserByName(String name);

    /**
     * 将用户信息存到redis
     * @param name
     */
    void setUserToRedis(String name);
}
