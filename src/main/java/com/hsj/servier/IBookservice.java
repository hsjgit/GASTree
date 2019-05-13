package com.hsj.servier;

import com.hsj.bean.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 黄仕杰 on 2019/5/3.
 */
public interface IBookservice {
    /**
     * 用户要把自己写的博客变成书时提供的添加操作
     * @param book
     */
    void add(Book book);

    /**
     * 查询用户弄到的书
     * @param author
     * @return
     */
    List<Book> select(String author);
}
