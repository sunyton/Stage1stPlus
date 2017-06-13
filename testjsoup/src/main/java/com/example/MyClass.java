package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyClass {





    public static void main(String args[]) throws IOException {
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


        Document doc = Jsoup.connect("http://bbs.saraba1st.com/2b/thread-1159835-1-1.html").get();
        Elements elements = doc.select("table[id~=pid]");
        for (Element element : elements) {
//            System.out.println(element.getElementsByClass("authi").text().split(" ")[0]+" "+element.getElementsByClass("authi").text().split(" ")[2]+" "+element.getElementsByClass("authi").text().split(" ")[3]);
//            System.out.println(element.getElementsByClass("avtm"));
//            System.out.println(element.select("em[id~=authorposton]").text().substring(3, 18));

//            System.out.println(element.getElementById("em[id~=authorposton]").text());
            System.out.println(element.getElementsByClass("t_f"));


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

//        测试运算


    }
}
