package com.hsj.entity;

import com.hsj.bean.Blog;
import com.hsj.bean.GetBlog;


/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/4.
 */
public class BlogToGetBolog {
    public static GetBlog getblog(Blog blog, String... strings) {
        GetBlog getBlog = new GetBlog();
        getBlog.setTitle(blog.getTitle());
        getBlog.setAuthor(strings[0]);
        getBlog.setPath(strings[1]);
        getBlog.setTime(strings[2]);
        return getBlog;
    }
}
