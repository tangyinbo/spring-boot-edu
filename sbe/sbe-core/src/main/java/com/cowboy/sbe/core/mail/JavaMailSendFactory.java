package com.cowboy.sbe.core.mail;/**
 * Created by Administrator on 2017/11/15/0015.
 */

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-15 9:55
 **/
public class JavaMailSendFactory {

    /**
     * 邮件发送服务缓存
     */
    private static final Cache<String, JavaMailSender> mailSenderCache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为10秒
            //.expireAfterWrite(10, TimeUnit.MINUTES)
            //五分钟没有别读取则清除
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .build();

    /**
     * 创建邮件发送器
     *
     * @param host
     * @param port
     * @param user
     * @param password
     * @return
     */
    public static JavaMailSender createMailSender(String host, int port, String user, String password) throws ExecutionException {
        JavaMailSender sender = mailSenderCache.get(host, new Callable<JavaMailSender>() {
            @Override
            public JavaMailSender call() throws Exception {
                System.out.println("-----------------------create mailSender:"+host+" -------------------");
                JavaMailSenderImpl sender = new JavaMailSenderImpl();
                sender.setHost(host);
                sender.setPort(port);
                sender.setUsername(user);
                sender.setPassword(password);
                sender.getJavaMailProperties().put("mail.smtp.auth", true);
                sender.getJavaMailProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                mailSenderCache.put(host, sender);
                return sender;
            }
        });
        return sender;
    }

    public static JavaMailSender createMailSender(MailSenderConfig mailSenderConfig) throws ExecutionException {
        JavaMailSender sender = mailSenderCache.get(mailSenderConfig.getHost(), new Callable<JavaMailSender>() {
            @Override
            public JavaMailSender call() throws Exception {
                System.out.println("-----------------------create mailSender:"+mailSenderConfig.getHost()+" -------------------");
                JavaMailSenderImpl sender = new JavaMailSenderImpl();
                sender.setHost(mailSenderConfig.getHost());
                sender.setPort(mailSenderConfig.getPort());
                sender.setUsername(mailSenderConfig.getUserName());
                sender.setPassword(mailSenderConfig.getPasswd());
                sender.getJavaMailProperties().put("mail.smtp.auth", true);
                sender.getJavaMailProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                mailSenderCache.put(mailSenderConfig.getHost(), sender);
                return sender;
            }
        });
        return sender;
    }




    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException, ExecutionException, InterruptedException {
        MailSenderConfig c1 = new MailSenderConfig("smtp.qq.com",465,"274267380@qq.com","ymngrutxwmkscaid");
        MailSenderConfig c2 = new MailSenderConfig("smtp.shabaozaixian.com",465,"service@shabaozaixian.com","Shabao1708");
        //
        sendMail(c1,"274267380@qq.com","hello myfriend","tangyinboit@163.com","my friend, we invite you to a party2",null);
        //sendMail(c2,"service@shabaozaixian.com","hello myfriend","274267380@qq.com","my friend, we invite you to a party2",null);


        Thread.sleep(10000);
        sendMail(c1,"274267380@qq.com","hello myfriend","tangyinboit@163.com","my friend, we invite you to a party2",null);

        //--------------------------------------

        sendMail(c2,"service@shabaozaixian.com","hello myfriend","274267380@qq.com","my friend, we invite you to a party2",null);

    }



    public static void sendMail(MailSenderConfig mailSenderConfig,String from,String subject,String to,String text,File file) throws MessagingException, UnsupportedEncodingException, ExecutionException {
        JavaMailSender sender = createMailSender(mailSenderConfig);
        MimeMessage mm = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mm, true, "utf-8");
        messageHelper.setFrom(from, "Tom ask");
        messageHelper.setSubject(subject);
        // messageHelper.setTo("tangyinboit@163.com");
        messageHelper.setTo(to);
        //获取邮件正文
        messageHelper.setText(text, true);
        if(file!= null){
            messageHelper.addAttachment(file.getName(),file);
        }
        sender.send(mm);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MailSenderConfig{
        private String host;
        private int port;
        private String userName;
        private String passwd;
    }
}
