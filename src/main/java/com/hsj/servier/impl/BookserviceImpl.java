package com.hsj.servier.impl;

import com.hsj.bean.Book;
import com.hsj.mapper.BookMapper;
import com.hsj.servier.IBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/3.
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class BookserviceImpl implements IBookservice {

    @Autowired
    private BookMapper bookMapper;
    /**
     * 用户要把自己写的博客变成书时提供的添加操作
     *
     * @param book
     */
    @Override
    public void add(Book book) {
        bookMapper.add(book);
    }

    /**
     * 查询用户把自己的博客编成的书
     *
     * @param author
     * @return
     */
    @Override
    public List<Book> select(String author) {
        return bookMapper.select(author);
    }
}
