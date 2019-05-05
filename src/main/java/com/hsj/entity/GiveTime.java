package com.hsj.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 为了保证线程安全
 * Created by 黄仕杰 on 2019/5/4.
 */
public class GiveTime {
    private static final DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String formatDate(LocalDateTime dateTime) {
        return time.format(dateTime);
    }
    public static LocalDateTime pares(String dateTime) {
        return LocalDateTime.parse(dateTime, time);
    }

}
