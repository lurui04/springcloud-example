package com.ljmoon.springcloud.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.email.service
 * @ClassName: EmailService
 * @Description: 邮件发送service类
 * @Date: 2019-03-13 14:19
 */
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(String from, String to, String subject, String content) {
        try {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            this.mailSender.send(mimeMessage);
            logger.info("send email success");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("异常信息：" + ex.getMessage());
        }
    }
}
