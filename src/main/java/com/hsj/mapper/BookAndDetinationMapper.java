package com.hsj.mapper;

import com.hsj.bean.BookAndDestination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/4.
 */
public interface BookAndDetinationMapper {
    void add(BookAndDestination book);
    List<BookAndDestination> select(@Param("author") String author);
}
