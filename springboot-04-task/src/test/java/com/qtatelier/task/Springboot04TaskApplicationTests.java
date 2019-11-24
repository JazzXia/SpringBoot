package com.qtatelier.task;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import sun.plugin2.message.Message;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Resource
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("1104841692@qq.com");
        message.setFrom("xia.weiwei163@163.com");
        mailSender.send(message);
    }

    @Test
    public void testComplex(){
        //1、创建一个复杂的消息邮件
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //邮件设置
            helper.setSubject("通知-今晚开会");
            helper.setText("<b style='color:red'>今天 7:30 开会</b><br><p>这是系统默认邮件，请勿回复，如包含垃圾信息请联系管理员@JazzXia</p><br><p>That's a test!!!</p>",true);

            helper.setTo("184616837@qq.com");
            helper.setFrom("xia.weiwei163@163.com");


            //上传文件
            helper.addAttachment("Cache.png",new File("C:\\Users\\Administrator\\Desktop\\Cache.png"));

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
