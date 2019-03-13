package com.ljmoon.springcloud.email;

import com.ljmoon.springcloud.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lurui
 * @Package: com.ljmoon.springcloud.email
 * @ClassName: EmailTest
 * @Description: 邮件服务测试类
 * @Date: 2019-03-13 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmailTest() {
        final String from = "luruigx08@163.com";
        final String to = "luruigx08@163.com";
        String subject = "Sentinl Alarm";
        String content = "Alerm of neon: 100 !";
        emailService.sendEmail(from, to, subject, content);
    }
}
