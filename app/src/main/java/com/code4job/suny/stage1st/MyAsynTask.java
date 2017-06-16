package com.code4job.suny.stage1st;

import android.os.AsyncTask;

import com.code4job.suny.stage1st.bean.ListInfo;
import com.code4job.suny.stage1st.utils.Spider;

import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class MyAsynTask extends AsyncTask<String,Void,List<?>> {


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected List<?> doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(List<?> objects) {
        super.onPostExecute(objects);
    }
}
