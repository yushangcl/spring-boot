package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.dao.CmUser;
import com.whh.spring.boot.mapper.CmUserMapper;
import com.whh.spring.boot.service.CmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
@Service
@Transactional
public class CmUserServiceImpl implements CmUserService {
    private static final Logger log = LoggerFactory.getLogger(CmUserServiceImpl.class);

    private static final String CM_USER_REDIS_KEY = "CM_USER_REDIS";

    @Resource
    private CmUserMapper cmUserMapper;

    @Resource
    private HashOperations<String, String, CmUser> hashOperations;

    @Override
    public CmUser getUserByName(String name) {
        return cmUserMapper.findByName(name);
    }

    @Override
    public void setUserToRedis(String name) {
        CmUser cmUser = this.getUserByName(name);
        hashOperations.put(CM_USER_REDIS_KEY, cmUser.getId().toString(), cmUser);
        log.debug("存入redis" + cmUser);
        cmUser = hashOperations.get(CM_USER_REDIS_KEY, cmUser.getId().toString());
    }
}
