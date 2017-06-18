package com.code4job.suny.stage1st.utils;

/**
 * Created by suny on 2017/6/12.
 */

public class Constants {
    public static String lolUrl = "http://bbs.saraba1st.com/2b/forum-111-1.html";
    public static String rootUrl = "http://bbs.saraba1st.com/2b/";
    public static String Sl = "http://bbs.saraba1st.com/2b/forum-140-1.html";
    public static String lushi = "http://bbs.saraba1st.com/2b/forum-132-1.html";
    public static String dotaUrl = "http://bbs.saraba1st.com/2b/forum-138-1.html";
    public static String mobileUrl = "http://bbs.saraba1st.com/2b/forum-135-1.html";
    public static String gameNew = "http://bbs.saraba1st.com/2b/forum-82-1.html";
    public static String game = "http://bbs.saraba1st.com/2b/forum-4-1.html";
    public static String ctAmer = "http://bbs.saraba1st.com/2b/forum-144-1.html";
    public static String ct = "http://bbs.saraba1st.com/2b/forum-6-1.html";
    public static String play = "http://bbs.saraba1st.com/2b/forum-136-1.html";
    public static String movie = "http://bbs.saraba1st.com/2b/forum-48-1.html";
    public static String music = "http://bbs.saraba1st.com/2b/forum-24-1.html";
    public static String Pc = "http://bbs.saraba1st.com/2b/forum-51-1.html";
    public static String wenshi = "http://bbs.saraba1st.com/2b/forum-50-1.html";
    public static String bian = "http://bbs.saraba1st.com/2b/forum-31-1.html";
    public static String sports = "http://bbs.saraba1st.com/2b/forum-77-1.html";
    public static String out = "http://bbs.saraba1st.com/2b/forum-75-1.html";
    public static String ershou = "http://bbs.saraba1st.com/2b/forum-115-1.html";
    public static String in = "http://bbs.saraba1st.com/2b/forum-27-1.html";


    public static String getUrl(String name) {
        String url = "";
        switch (name) {
            case "游戏论坛":
                url = Constants.game;
                break;
            case "欧美动漫":
                url = Constants.ctAmer;
                break;
            case "动漫论坛":
                url = Constants.ct;
                break;
            case "模玩专区":
                url = Constants.mobileUrl;
                break;
            case "影视论坛":
                url = Constants.movie;
                break;
            case "音乐论坛":
                url = Constants.music;
                break;
            case "PC数码":
                url = Constants.Pc;
                break;
            case "文史沙龙":
                url = Constants.wenshi;
                break;
            case "彼岸文化":
                url = Constants.bian;
                break;
            case "八卦体育":
                url = Constants.sports;
                break;
            case "外野":
                url = Constants.out;
                break;
            case "内野":
                url = Constants.in;
                break;
            case "二手交易区":
                url = Constants.ershou;
                break;
            case "炉石传说":
                url = Constants.lushi;
                break;
            case "DOTA":
                url = Constants.dotaUrl;
                break;
            case "手游页游":
                url = Constants.mobileUrl;
                break;
            case "英雄联盟(LOL)":
                url = Constants.lolUrl;
                break;
            case "新网游综合讨论区":
                url = Constants.gameNew;
                break;
            case "页游S1官方联运":
                url = Constants.Sl;
                break;

        }

        return url;
    }


}
