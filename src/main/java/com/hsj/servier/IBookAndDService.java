package com.hsj.servier;

import com.hsj.bean.BookAndDestination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/5/4.
 */
@Service
public interface IBookAndDService {
    void add(BookAndDestination bookAndDestination);
    List<BookAndDestination> select(String author);
}
