package com.code4job.suny.stage1st.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.Holder> {

    private List<String> homeList;

    public HomeRVAdapter(List<String> homeList) {
        this.homeList = homeList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public Holder(View itemView) {

            super(itemView);
        }
    }
}
