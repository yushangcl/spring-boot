package com.whh.spring.boot.controller;

import com.whh.spring.boot.dao.CmUser;
import com.whh.spring.boot.service.CmUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
@RestController
@RequestMapping("/user")
public class CmUserController {

    @Resource
    private CmUserService cmUserService;

    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public CmUser getUserByName() {
        return cmUserService.getUserByName("张三");
    }

}
