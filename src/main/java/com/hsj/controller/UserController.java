package com.hsj.controller;

import com.hsj.common.UUIDUtils;
import com.hsj.bean.User;
import com.hsj.servier.UserServicer;
import org.apache.catalina.Session;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.spi.SyncResolver;
import java.util.List;
import java.util.Map;

/**
 * Created by 黄仕杰 on 2019/4/13.
 */
@Controller
public class UserController {

    @Autowired

    private UserServicer userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/registerUser")
    public String register(User user){

        user.setStatus(0);
        String code = UUIDUtils.getUUID()+ UUIDUtils.getUUID();
        user.setCode(code);
        userService.register(user);
        return "success";
    }

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        User user = userService.checkCode(code);
        System.out.println(user);
        //如果用户不等于null，把用户状态修改status=1
        if (user !=null){
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
            request.getSession().setAttribute("user", user);
            String name=(user.getUsername().substring(0,1).toUpperCase());
            request.getSession().setAttribute("name", name);
            return "index";
        }
       request.getSession().setAttribute("msg","密码或账号错误");
        return "login";
    }
}
