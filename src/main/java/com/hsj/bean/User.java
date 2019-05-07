package com.hsj.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String useremail;
    /**
     * 状态：0代表未激活，1代表激活
     */
    private Integer status;
    /**
     * 利用UUID生成一段数字，发动到用户邮箱，当用户点击链接时
     * 在做一个校验如果用户传来的code跟我们发生的code一致，更改状态为“1”来激活用户
     */
    private String  code;

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if (this.username .equals(user.username)  && this.password .equals(user.password) ) {
            return true;
        }else {
            return false;
        }
    }

    public boolean havauser(List<User> list) {
        int count = 0;
        for (User user : list) {
            if (this.equals(user)) {
                count=1;
            }
        }
        return count == 1 ? true : false;

    }
}
