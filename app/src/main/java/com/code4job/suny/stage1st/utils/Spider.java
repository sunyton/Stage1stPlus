package com.code4job.suny.stage1st.utils;

import com.code4job.suny.stage1st.bean.ListInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class Spider {




    public static List<ListInfo> getInfo(String url) throws IOException {

        List<ListInfo> mListInfos = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("tbody[id~=normalthread] > tr");
        for (Element element : elements) {
            ListInfo listInfo = new ListInfo();

            listInfo.setTopicName(element.getElementsByTag("em").text().split(" ")[0].substring(1, element.getElementsByTag("em").text().split(" ")[0].length() - 1));
            listInfo.setReadNum(element.getElementsByTag("em").text().split(" ")[3]);
            listInfo.setTpBody(element.getElementsByClass("s xst").text());
            listInfo.setReplyNum(element.getElementsByClass("xi2").text());
            listInfo.setUserName(element.getElementsByClass("by").text().split(" ")[0]);
            listInfo.setReplyDate(TimeUtils.handleTime(element.getElementsByClass("by").text().split(" ")[4] + " " + element.getElementsByClass("by").text().split(" ")[5]));
            listInfo.setUrl(element.getElementsByClass("s xst").attr("href"));

            mListInfos.add(listInfo);

        }
        return mListInfos;



    }
}
