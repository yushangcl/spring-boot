package com.whh.spring.boot.mapper;

import com.whh.spring.boot.BaseTest;
import com.whh.spring.boot.dao.CmUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
public class CmCmUserMapperTest extends BaseTest {

    @Autowired
    private CmUserMapper cmUserMapper;

    @Test
    public void findByName() throws Exception {
        CmUser cmUser = cmUserMapper.findByName("张三");
        System.out.println(cmUser);
    }

    @Test
    public void insert() throws Exception {
        cmUserMapper.insert("李四", 20);
    }

    @Test
    public void update() throws Exception {
        CmUser cmUser = new CmUser();
        cmUser.setId(1L);
        cmUser.setAge(15);
        cmUserMapper.update(cmUser);
    }

    @Test
    public void delete() throws Exception {
        cmUserMapper.delete(1L);
    }

}