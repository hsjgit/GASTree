package com.hsj.mapper;

import com.hsj.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 黄仕杰 on 2019/5/3.
 */
public interface BookMapper {
    void add(Book book);
    List<Book> select(@Param("author") String author);
}
