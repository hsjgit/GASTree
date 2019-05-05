package com.hsj.servier;

import org.springframework.stereotype.Service;

/**
 * Created by 黄仕杰 on 2019/4/13.
 */
@Service
public interface MailService {
    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    //void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件，方便用户点击附带的code用来验证激活账户
     * @param to
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);


}
