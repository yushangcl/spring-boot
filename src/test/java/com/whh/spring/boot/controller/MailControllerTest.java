package com.whh.spring.boot.controller;

import com.whh.spring.boot.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author huahui.wu.
 *         Created on 2018/1/11.
 */
public class MailControllerTest extends BaseTest {

    @Resource
    private MailController mailController;
    @Test
    public void sendAttachmentsMail() throws Exception {
        mailController.sendAttachmentsMail();
    }

}