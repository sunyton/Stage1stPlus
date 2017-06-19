package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyClass {


    public static void main(String args[]) throws IOException, ParseException {
//        Document doc = Jsoup.connect("http://bbs.saraba1st.com/2b/forum-111-1.html").get();
//        Elements elements = doc.select("tbody[id~=normalthread] > tr");
//        for (Element element : elements) {
////            System.out.println(element.getElementsByTag("em").text().split(" ")[0]+" "+element.getElementsByTag("em").text().split(" ")[3]);
////            System.out.println(element.getElementsByClass("s xst").attr("href"));
////            System.out.println(element.getElementsByClass("xi2").text());
////            System.out.println(element.getElementsByClass("by").text());
//
//
//
//        }


//        Document doc = Jsoup.connect("http://bbs.saraba1st.com/2b/thread-1159835-1-1.html").get();
//        Elements elements = doc.select("table[id~=pid]");
//        for (Element element : elements) {
////            System.out.println(element.getElementsByClass("authi").text().split(" ")[0]+" "+element.getElementsByClass("authi").text().split(" ")[2]+" "+element.getElementsByClass("authi").text().split(" ")[3]);
////            System.out.println(element.getElementsByClass("avtm"));
////            System.out.println(element.select("em[id~=authorposton]").text().substring(3, 18));
//
////            System.out.println(element.getElementById("em[id~=authorposton]").text());
//            System.out.println(element.getElementsByClass("t_f"));

        //        时间转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = "2017-4-06 12:45";
        String sTime = "";
        Date date = simpleDateFormat.parse(time);
        long now = Calendar.getInstance().getTimeInMillis();
        long deltime = (now - date.getTime()) / 1000;
        System.out.println(deltime);

        if (deltime > 365 * 24 * 3600) {
            sTime = (int)(deltime / (365 * 24 * 3600)) + "年前";

        } else if (deltime > 24 * 3600) {
            sTime = (int)(deltime /(24 * 3600)) + "天前";

        } else if (deltime > 3600) {
            sTime = (int)(deltime / 3600) + "小时前";
        } else if (deltime > 60) {
            sTime = (int)(deltime / 60)  + "分钟前";
        } else if (deltime > 1) {
            sTime = deltime + "秒前";
        } else {
            sTime = "1秒前";
        }
        System.out.print(sTime);

    }


//        测试时间
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int date = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour = calendar.get(Calendar.HOUR);
//        int minute = calendar.get(Calendar.MINUTE);
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(date);
//        System.out.println(hour);
//        System.out.println(minute);





}
