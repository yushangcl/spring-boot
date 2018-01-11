package com.whh.spring.boot.controller;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author huahui.wu.
 *         Created on 2018/1/11.
 */
@Component
public class MailController {
    @Resource
    private JavaMailSender mailSender;

    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("lov.m@qq.com");
        helper.setTo("vr.i@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

//        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
//        helper.addAttachment("附件-1.jpg", file);
//        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);

    }
}
