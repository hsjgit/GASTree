package com.hsj.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * <p>为了保证线程安全<p/>
 * @author waja
 * Created by 黄仕杰 on 2019/5/4
 */
@Component
public class GiveTime {
    private static final DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String formatDate(LocalDateTime dateTime) {
        return time.format(dateTime);
    }
    public static LocalDateTime pares(String dateTime) {
        return LocalDateTime.parse(dateTime, time);
    }

}
