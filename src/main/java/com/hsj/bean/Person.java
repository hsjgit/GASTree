package com.hsj.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/25.
 */
@Data
@Component
public class Person {
    private String name;
    private int value;
    private String coordinate;
}
