package com.hsj.common;

import java.util.UUID;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
