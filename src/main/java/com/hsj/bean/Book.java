package com.hsj.bean;

import lombok.Data;

/**
 * Created by 黄仕杰 on 2019/4/30.
 */
@Data
public class Book {
    public String name;
    public int id;
    /**
     * <p>写的博客还有个分类不要忘了<p/>
     *     public String classification;
     */
    public int number;
    private String author;
    private String path;
}
