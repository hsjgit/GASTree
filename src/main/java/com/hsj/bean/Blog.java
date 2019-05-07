package com.hsj.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/14.
 */
@Data
public class Blog implements Serializable {
    private Integer id;
    /**
     * 博客的标题
     */
    private String title;
    /**
     * 这个是什么？当时怎么想的，看来还是要写注释
     */
    private String summary;
    /**
     * 写进文件的博客内容
     */
    private String content;
    /**
     * html的格式的博客内容
     */
    private String htmlContent;
    List<String> list = new ArrayList<>();
}
