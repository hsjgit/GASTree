package com.hsj.servier.impl;

import com.hsj.bean.GetBlog;
import com.hsj.mapper.GetBlogMapper;
import com.hsj.servier.IGetservier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>这个是博客最后查询的service层<p/>
 * @author waja
 * Created by 黄仕杰 on 2019/5/3.
 */
@Service
public class GetServiceImpl implements IGetservier {

    @Autowired
    private GetBlogMapper servier;
    /**
     * <p>添加博客<p/>
     *
     * @param getBlog
     */
    @Override
    public void add(GetBlog getBlog) {
        servier.add(getBlog);
    }

    /**
     * <p>更新，这里的只是更新标题<p/>
     *
     * @param getBlog
     */
    @Override
    public void updata(GetBlog getBlog) {
        servier.updata(getBlog);
    }

    /**
     * <p>删除，全部删除<p/>
     *
     * @param getBlog
     */
    @Override
    public void delete(GetBlog getBlog) {
        servier.delete(getBlog);
    }

    /**
     * <p>全部查出来<p/>
     *
     * @param author
     * @return
     */
    @Override
    public List<GetBlog> select(String author) {
        return servier.select(author);
    }
}
