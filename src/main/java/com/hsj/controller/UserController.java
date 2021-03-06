package com.hsj.controller;

import com.hsj.common.UUIDUtils;
import com.hsj.bean.User;
import com.hsj.entity.temporary.UserClass;
import com.hsj.servier.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@Controller
public class UserController {

    @Autowired

    private UserServicer userService;
    @Autowired
    private UserClass userClass;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/registerUser")

    public String register(User user) {

        user.setStatus(0);
        String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        user.setCode(code);
        userService.register(user);
        return "success";
    }

    /**
     * 校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code) {
        User user = userService.checkCode(code);
        System.out.println(user);
        //如果用户不等于null，把用户状态修改status=1
        if (user != null) {
            user.setStatus(1);
            //把code验证码清空，已经不需要了
            user.setCode("");
            System.out.println(user);
            userService.updateUserStatus(user);
        }
        return "login";
    }

    @RequestMapping(value = "/loginin")
    public String loginin(User user, HttpServletRequest request) {
        List<User> list = (List<User>) request.getServletContext().getAttribute("alluser");
        if (user.havauser(list)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String name = (user.getUsername().substring(0, 1).toUpperCase());
            session.setAttribute("name", name);
            try {
                userClass.goser("D:\\userclass\\data.ser",user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "index";
        }
        request.getSession().setAttribute("msg", "密码或账号错误");
        return "login";
    }
}
