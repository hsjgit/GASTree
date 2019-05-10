package com.hsj.controller;

import com.hsj.bean.BookAndDestination;
import com.hsj.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 黄仕杰
 * 写的一些简单的服务
 * Created by 黄仕杰 on 2019/4/30.
 */
@Controller
public class ServerController {
    @Autowired

    /**
     * 跳到捐本书书页面
     * @param book
     * @return
     */
    @RequestMapping(value = "/server1")
    public String givebook() {

        return "adai/tpmo/contact";
    }
    /**
     * 捐书的时候还有一个添加地址一栏，我不会加，就是有跳到另外一个页面上去在在添加
     * @return
     */
    @RequestMapping(value = "/server2")
    public String givebootanddizi(BookAndDestination book) {
        return "index";
    }
    @RequestMapping(value = "/givemeabook")
    public String bianshu(){

        return "xuanshu";
    }
    @RequestMapping(value = "/server3")
    public String catbook(){
        return "";
    }
    /**
     * <p><p/>
     * 处理一些遍书的细节，比如
     * @param map
     * @return
     */
    @RequestMapping(value = "/xs")
    public String a(@RequestParam Map<String,String> map,HttpServletRequest request) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
        return "index";
    }
    /**
     * <p>跳到home页面，因为没有做登录拦截所以就手动判断了session有没有user，没有做登录拦截是应为
     * 不知道为什么SpringBoot2.0放过了静态资源但是还是会拦击，所以就干脆不拦截了<p/>
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/home")
    public String gohome(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user == null ? "login" : "redirect:/home1?"+"name=123";
    }
}
