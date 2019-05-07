package com.hsj.mapper;

import com.hsj.bean.GetBlog;
import com.sun.org.apache.xpath.internal.operations.Gte;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/3.
 */
public interface GetBlogMapper {
    /**
     * <p>添加博客信息，作者，路径等<p/>
     * @param getBlog
     */
    void add(GetBlog getBlog);

    /**
     * <></>
     * @param getBlog
     */
    void updata(GetBlog getBlog);

    /**
     * <></>
     * @param getBlog
     */
    void delete(GetBlog getBlog);

    /**
     * <></>
     * @param author
     * @return
     */
    List<GetBlog> select(@Param("author") String author);

}
