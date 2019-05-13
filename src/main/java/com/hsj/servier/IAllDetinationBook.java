package com.hsj.servier;

import com.hsj.bean.AllDetinationBook;

import java.util.List;

/**
 * @author waja
 */
public interface IAllDetinationBook {
    /**
     * <p>把所有可以捐的书都查出来<p/>
     * @return
     */
    List<AllDetinationBook> select();

    /**
     * <p>添加可以捐的书<p/>
     * @param allDetinationBook
     */
    void add(AllDetinationBook allDetinationBook);
}
