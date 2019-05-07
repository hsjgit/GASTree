package com.hsj.entity;

import com.hsj.bean.Blog;
import com.hsj.bean.GetBlog;
import com.hsj.servier.otherservice.GivePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/4.
 */
@Component
public class BlogToGetBolog {
    @Autowired
    private GivePath givePath;
    public GetBlog getblog(Blog blog,GetBlog getBlog) throws IOException {
        String time = GiveTime.formatDate(LocalDateTime.now());
        String path=givePath.getPath(blog);
        getBlog.setTitle(blog.getTitle());
        getBlog.setPath(path);
        getBlog.setTime(time);
        return getBlog;
    }
}
