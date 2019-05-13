package com.hsj.mapper;
import com.hsj.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author waja
 * Created by 黄仕杰 on 2019/2/17.
 */
public interface UserMapper {
    /**
     * 用户注册，注册的时候默认状态为0：未激活，并且调用邮件服务发送激活码到邮箱
     * @param user
     */
    void register(User user);

    /**
     * 点击邮箱中的激活码进行激活，根据激活码查询用户，之后再进行修改用户状态为1进行激活
     * @param code
     * @return
     */
    User checkCode(String code);

    /**
     * 激活账户，修改用户状态为“1”进行激活
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 登录，根据用户状态为“1”来查询
     * @param user
     * @return
     */
    User loginUser(User user);
    List<User> alllist();

    void delete(@Param("name") String name);
}
