package com.hsj.servier.impl;

import com.hsj.bean.User;
import com.hsj.mapper.UserMapper;
import com.hsj.servier.MailService;
import com.hsj.servier.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄仕杰 on 2019/4/13.
 */
@Service
public class UserServiceImpl implements UserServicer {
    @Autowired
    private UserMapper userDao;

    /**
     * 注入邮件接口
     */
    @Autowired
    private MailService mailService;

    /**
     * 用户注册，同时发送一封激活邮件
     *
     * @param user
     */
    @Override
    public void register(User user) {
        userDao.register(user);
        //获取激活码
        String code = user.getCode();
        //主题
        String subject = "来自Waja的激活邮件";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=http://localhost:8080/checkCode?code=" + code + ">激活请点击:" + code + "</a>";
        //发送激活邮件
        mailService.sendHtmlMail(user.getUseremail(), subject, context);
    }

    /**
     * 根据激活码code进行查询用户，之后再进行修改状态
     *
     * @param code
     * @return
     */
    @Override
    public User checkCode(String code) {

        return userDao.checkCode(code);
    }

    /**
     * 激活账户，修改用户状态
     *
     * @param user
     */
    @Override
    public void updateUserStatus(User user) {
        userDao.updateUserStatus(user);
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User loginUser(User user) {
        User user1 = userDao.loginUser(user);
        if (user1 != null) {
            return user1;
        }
        return null;
    }

    @Override
    public List<User> alllist() {
        return userDao.alllist();
    }
}
