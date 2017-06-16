package com.code4job.suny.stage1st.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code4job.suny.stage1st.MainActivity;
import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.adapter.ComRvAdapter;
import com.code4job.suny.stage1st.adapter.ListAdapter;
import com.code4job.suny.stage1st.bean.ListInfo;
import com.code4job.suny.stage1st.utils.Constants;
import com.code4job.suny.stage1st.utils.Spider;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class FragmentRv extends Fragment {

    private RecyclerView rv;
    private List<ListInfo> lists = new ArrayList<>();
    private AVLoadingIndicatorView fragAvi;
    private MyTask mMyTask;
    private String url;

    public FragmentRv(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentrv, container, false);

        rv = (RecyclerView) view.findViewById(R.id.fragrv);
        fragAvi = (AVLoadingIndicatorView) view.findViewById(R.id.frag_avi);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);
        mMyTask = new MyTask();
        mMyTask.execute(url);
        return view;
    }


    class MyTask extends AsyncTask<String, Void, List<ListInfo>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            fragAvi.show();
        }

        @Override
        protected List<ListInfo> doInBackground(String... params) {

            String url = params[0];
            try {
                lists = Spider.getInfo(url);
            } catch (IOException e) {
                e.printStackTrace();

            }
            return lists ;
        }

        @Override
        protected void onPostExecute(List<ListInfo> list) {
            super.onPostExecute(list);
            if (list != null) {
                fragAvi.hide();
                rv.setAdapter(new ListAdapter(lists, getActivity()));
            }
        }
    }

}
