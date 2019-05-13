package com.hsj.servier.impl;

import com.hsj.bean.AllDetinationBook;
import com.hsj.mapper.AllDetinationBookMapper;
import com.hsj.servier.IAllDetinationBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author waja
 * <p>对可以捐的书的查询和添加的操作<p/>
 */
@Service
public class AllDetinationBookImpl implements IAllDetinationBook {
    @Autowired
    private AllDetinationBookMapper book;
    /**
     * <p>把所有可以捐的书都查出来<p/>
     *
     * @return
     */
    @Override
    public List<AllDetinationBook> select() {
        return book.select();
    }

    /**
     * <p>添加可以捐的书<p/>
     *
     * @param allDetinationBook
     */
    @Override
    public void add(AllDetinationBook allDetinationBook) {
        book.add(allDetinationBook);

    }
}
