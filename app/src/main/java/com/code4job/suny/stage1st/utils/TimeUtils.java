package com.code4job.suny.stage1st.utils;


import java.util.Calendar;


/**
 * Created by suny on 2017/6/12.
 */

public class TimeUtils {

    public static String handleTime(String timeStr) {
        String day = "";
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int yearGet = Integer.parseInt(timeStr.split(" ")[0].split("-")[0]);
        int mouthGet = Integer.parseInt(timeStr.split(" ")[0].split("-")[1]);
        int dayGet = Integer.parseInt(timeStr.split(" ")[0].split("-")[2]);
        int hourGet = Integer.parseInt(timeStr.split(" ")[1].split(":")[0]);
        int minGet = Integer.parseInt(timeStr.split(" ")[1].split(":")[1]);
        if (String.valueOf(minGet).substring(0, 1) == "0"|String.valueOf(hourGet).substring(0, 1) == "0") {
            minGet = Integer.parseInt(String.valueOf(minGet).substring(1, 1));
        }
        if (yearGet == year) {
            if (mouthGet == month) {
                if (dayGet == date) {
                    if (hourGet == hour) {
                        if (minGet == minute) {
                            day = "刚刚";
                        } else {
                            int dayTime = minute - minGet;
                            day = String.valueOf(dayTime) + "分钟前";
                        }
                    } else {
                        int dayTime = hour - hourGet;
                        day = String.valueOf(dayTime) + "小时前";
                    }
                } else {
                    int dayTime = date - dayGet;
                    day = String.valueOf(dayTime) + "天前";
                }
            } else {
                int dayTime = month - mouthGet;
                day = String.valueOf(dayTime) + "月前";
            }
        } else {
            int dayTime = year - yearGet;
            day = String.valueOf(dayTime) + "年前";

        }


        return day;
    }
}
