package com.hsj.mapper;

import com.hsj.bean.AllDetinationBook;

import java.util.List;

/**
 * @author waja
 */
public interface AllDetinationBookMapper {
    List<AllDetinationBook> select();

    void add(AllDetinationBook allDetinationBook);
}
