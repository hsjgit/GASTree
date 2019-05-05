package com.hsj.mapper;

import com.hsj.bean.GetBlog;
import com.sun.org.apache.xpath.internal.operations.Gte;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 黄仕杰 on 2019/5/3.
 */
public interface GetBlogMapper {
    void add(GetBlog getBlog);
    void updata(GetBlog getBlog);

    void delete(GetBlog getBlog);

    List<GetBlog> select(@Param("author") String author);

}
