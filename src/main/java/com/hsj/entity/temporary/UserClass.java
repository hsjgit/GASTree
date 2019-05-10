package com.hsj.entity.temporary;

import com.hsj.bean.User;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author waja
 * </p> 为了解决写博客后由于不同请求产生的两种会话，我把用户的信息给序列化<p/>
 */
@Component
public class UserClass {
    /**
     * 对象反序列化
     *@param str 指定对象反序列化路径，生成一个java类
     */
    public Object getser(String str)throws  Exception{
        FileInputStream file = new FileInputStream(str);
        ObjectInputStream e = new ObjectInputStream(file);
        Object object = (User) e.readObject();
        e.close();
        file.close();
        return object;
    }
    /**
     * 对象序列化
     *@param str 获取对象的路径
     *@param o 接收序列化后的对象
     */
    public void goser(String str,Object o)throws Exception{
        FileOutputStream file = new FileOutputStream(str);
        ObjectOutputStream e = new ObjectOutputStream(file);
        e.writeObject(o);
        e.close();
        file.close();

    }
}
