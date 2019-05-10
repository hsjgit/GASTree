package com.hsj.bean;

import lombok.Data;

/**
 * @author waja
 * <p>平台所有可以捐献的书<p/>
 */
@Data
public class AllDetinationBook {
    private int id;
    /**
     * <p>平台拥有可以捐的书的名字<p/>
     */
    private String bookname;
    /**
     * <p>书的编号<p/>
     */
    private String booknumber;
    /**
     * <p>剩余书的数量<p/>
     */
    private int number;
}
