package com.code4job.suny.stage1st;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.code4job.suny.stage1st.adapter.ListAdapter;
import com.code4job.suny.stage1st.adapter.MyItemDecoration;
import com.code4job.suny.stage1st.bean.ListInfo;
import com.code4job.suny.stage1st.utils.TimeUtils;
import com.wang.avi.AVLoadingIndicatorView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ListInfo> mListInfos = new ArrayList<>();
    private AVLoadingIndicatorView avi;
    private RecyclerView mRecyclerView;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        avi.show();
        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    avi.hide();
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setAdapter(new ListAdapter(mListInfos));
//                    mRecyclerView.addItemDecoration(new MyItemDecoration());

                }

            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                try {
                    getInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                msg.what = 1;
                mHandler.sendMessage(msg);
            }
        }).start();



    }


    public void getInfo() throws IOException {
        Document doc = Jsoup.connect("http://bbs.saraba1st.com/2b/forum-111-1.html").get();
        Elements elements = doc.select("tbody[id~=normalthread] > tr");
        for (Element element : elements) {
            ListInfo listInfo = new ListInfo();
            listInfo.setTopicName(element.getElementsByTag("em").text().split(" ")[0].substring(1, element.getElementsByTag("em").text().split(" ")[0].length() - 1));
            listInfo.setReadNum(element.getElementsByTag("em").text().split(" ")[3]);
            listInfo.setTpBody(element.getElementsByClass("s xst").text());
            Log.i("TAG", element.getElementsByClass("s xst").text());
            listInfo.setReplyNum(element.getElementsByClass("xi2").text());
            listInfo.setUserName(element.getElementsByClass("by").text().split(" ")[0]);
            listInfo.setReplyDate(TimeUtils.handleTime(element.getElementsByClass("by").text().split(" ")[4] + " " + element.getElementsByClass("by").text().split(" ")[5]));
            mListInfos.add(listInfo);

        }
    }
}
