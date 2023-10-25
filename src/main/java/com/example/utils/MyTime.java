package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {
    /*
    public static String getTime(){
        String str=String.valueOf(new Date());
        System.out.println("new Date time : "+new Date());
        System.out.println("str time : "+str);
        return str;
    }
    */
    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        return dateStr;

    }
}
