package com.code4job.suny.stage1st.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.adapter.HomeRVAdapter;

import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class FragmentTab extends Fragment {

    private RecyclerView rv;
    private String[] mList;

    public FragmentTab(String[] list) {
        mList = list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        rv = (RecyclerView) view.findViewById(R.id.homelist);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);
        rv.setAdapter(new HomeRVAdapter(mList,getActivity()));
        return view;
    }
}
