package com.code4job.suny.stage1st;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.code4job.suny.stage1st.adapter.ComRvAdapter;
import com.code4job.suny.stage1st.bean.CommentInfo;
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

public class CommentActivity extends AppCompatActivity {

    private List<CommentInfo> mList = new ArrayList<>();
    private String msg;
    private RecyclerView rv;
    private AVLoadingIndicatorView avi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        avi = (AVLoadingIndicatorView) findViewById(R.id.com_wait);
        avi.show();

        Intent intent = getIntent();
        msg = "http://bbs.saraba1st.com/2b/" + intent.getStringExtra("url");
        rv = (RecyclerView) findViewById(R.id.rv_comment);
        rv.setLayoutManager(new LinearLayoutManager(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getComment(msg);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            avi.hide();
                            rv.setHasFixedSize(true);
                            rv.setAdapter(new ComRvAdapter(mList));
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }



    public void getComment(String msg) throws IOException {

        Document doc = Jsoup.connect(msg).get();
        Elements elements = doc.select("table[id~=pid]");
        for (Element element : elements) {
//            System.out.println(element.getElementsByClass("authi").text().split(" ")[0]+" "+element.getElementsByClass("authi").text().split(" ")[2]+" "+element.getElementsByClass("authi").text().split(" ")[3]);
//            System.out.println(element.getElementsByClass("t_f"));
            CommentInfo commentInfo = new CommentInfo();
            commentInfo.setUserId(element.getElementsByClass("authi").text().split(" ")[0]);
            Log.i("TAG", element.select("em[id~=authorposton]").text().substring(4, 18));
            commentInfo.setTime(TimeUtils.handleTime(element.select("em[id~=authorposton]").text().split(" ")[1]+" "+element.select("em[id~=authorposton]").text().split(" ")[2]));
            commentInfo.setComBody(element.getElementsByClass("t_f").toString());
            mList.add(commentInfo);

        }

    }

    class MyTask extends AsyncTask<String, Void, List<ListInfo>> {


        @Override
        protected void onPreExecute() {
            avi.show();
        }

        @Override
        protected List<ListInfo> doInBackground(String... params) {



            return null;
        }

        @Override
        protected void onPostExecute(List<ListInfo> list) {
            super.onPostExecute(list);
        }
    }
}
