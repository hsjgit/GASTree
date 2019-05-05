package com.hsj.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>用户捐的书<p/>
 * Created by 黄仕杰 on 2019/5/3.
 */
@Data
public class BookAndDestination implements Serializable{
    private String bookname;
    private String author;
    private String email;
    private String diqu;
    private String text;
    private String time;
}
