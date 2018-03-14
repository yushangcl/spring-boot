package com.whh.spring.boot.controller;

import com.whh.spring.boot.dao.CallRequest;
import com.whh.spring.boot.utils.DubboCallbackUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huahui.wu.
 *         Created on 2018/3/14.
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @RequestMapping(value = "/callJson")
    @ResponseBody
    public Object call(@RequestBody CallRequest request) {
        return DubboCallbackUtil.invoke(request.getInterfaceName(), request.getMethod(), request.getParam(), request.getAddress(), request.getVersion());
    }
}
