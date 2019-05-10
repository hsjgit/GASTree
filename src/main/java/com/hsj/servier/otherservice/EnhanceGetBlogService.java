package com.hsj.servier.otherservice;

import com.hsj.bean.Blog;
import com.hsj.bean.GetBlog;
import com.hsj.bean.User;
import com.hsj.entity.BlogToGetBolog;
import com.hsj.servier.impl.GetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * <p>对GetBlogService功能的增强，主要是在进行增删改查之前对数据的处理<p/>
 * @author waja
 * @class EnhanceGetBlogService
 */
@Component
public class EnhanceGetBlogService {
    @Autowired
    private GetServiceImpl getService;
    @Autowired
    private BlogToGetBolog blogToGetBolog;

    /**
     * 把新的博客路劲添加到数据库,等之后有时间在做aop
     * @param blog 前端传来的博客的数据
     * @param user 用户
     */
    public void addPath(Blog blog, User user,String video) throws IOException {
        GetBlog getBlog = new GetBlog();
        blogToGetBolog.getblog(blog, getBlog);
        getBlog.setAuthor(user.getUsername());
        System.out.println(user.getUsername());
        getBlog.setVideo(video);
        getService.add(getBlog);
    }
}
