package com.hsj.controller;

import com.hsj.bean.GlobalVaiable;
import com.hsj.bean.User;
import com.hsj.servier.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@Controller
public class IndexController {
    @Autowired
    private UserServiceImpl service;
    /**
     * 首页，localhost:8080直接返回index页面
     */
    @RequestMapping(value = "/")
    public String index(HttpServletRequest request){
        List<User> list=service.alllist();
        ServletContext context=request.getServletContext();
        context.setAttribute("alluser", list);
        return "index";
    }
}