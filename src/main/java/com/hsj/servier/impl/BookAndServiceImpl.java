package com.hsj.servier.impl;

import com.hsj.bean.BookAndDestination;
import com.hsj.mapper.BookAndDetinationMapper;
import com.hsj.servier.IBookAndDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>捐书的查询<p/>
 * Created by 黄仕杰 on 2019/5/4.
 */
@Service
public class BookAndServiceImpl implements IBookAndDService {
    @Autowired
    private BookAndDetinationMapper bookAndDetinationMapper;
    @Override
    public void add(BookAndDestination bookAndDestination) {
        bookAndDetinationMapper.add(bookAndDestination);
    }

    @Override
    public List<BookAndDestination> select(String author) {

        return bookAndDetinationMapper.select(author);
    }
}
