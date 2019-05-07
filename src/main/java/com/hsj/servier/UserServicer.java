package com.hsj.servier;

import com.hsj.bean.User;

import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
public interface UserServicer {
    /**
     * 用户注册,
     * @param user
     */
    void register(User user);

    /**
     * 根据激活码code查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    User checkCode(String code);

    /**
     * 激活账户，修改用户状态为“1”
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User loginUser(User user);
    List<User> alllist();
}
