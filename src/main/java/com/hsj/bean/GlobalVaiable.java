package com.hsj.bean;

import com.hsj.bean.User;
import com.hsj.servier.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * <p>为了登录的时候可以快快一点，提前一次性把所有用户都先查出来<p/>
 * Created by 黄仕杰 on 2019/5/3.
 */
@Component
public class GlobalVaiable {
    @Autowired
    private UserServiceImpl service;
    private List<User> list;
    public List<User> getList() {
        return service.alllist();
    }

}
