package com.hsj.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by 黄仕杰 on 2019/4/14.
 */
@Data
public class Blog implements Serializable{
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String htmlContent;
}
