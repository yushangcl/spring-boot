package com.whh.spring.boot.springboot.controller;

import com.whh.spring.boot.springboot.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huahui.wu.
 *         Created on 2018/1/9.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    /**
     * 全局异常测试
     * @return
     * @throws Exception
     */
    @RequestMapping("/ex")
    public String ex() throws Exception {
        throw new Exception("Exception");
    }

    /**
     * 自定义异常处理
     * @return
     * @throws Exception
     */
    @RequestMapping("/se")
    public String se() throws Exception {
        throw new ServiceException(1001, "ServiceException");
    }

}
