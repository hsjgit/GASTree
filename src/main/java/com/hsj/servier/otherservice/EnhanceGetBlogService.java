package com.hsj.servier.otherservice;

import com.hsj.bean.Blog;
import com.hsj.bean.GetBlog;
import com.hsj.servier.impl.GetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>对GetBlogService功能的增强，主要是在进行增删改查之前对数据的处理<p/>
 * @author waja
 * @class EnhanceGetBlogService
 */
@Component
public class EnhanceGetBlogService {
    @Autowired
    private GetServiceImpl getService;
    /**
     * 把新的博客路劲添加到数据库
     * @param getBlog
     * @return
     */
    public boolean addPath(GetBlog getBlog){
        getService.add(getBlog);
        return false;
    }
}
