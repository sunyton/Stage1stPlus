package com.code4job.suny.stage1st.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.adapter.MyPagerAdapter;
import com.code4job.suny.stage1st.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by suny on 2017/6/16.
 */

public class FragmentLove extends Fragment {

    private TabLayout tb;
    private ViewPager vp;
    private List<FragmentRv> mFragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private SharedPreferences sp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_love, container, false);

        tb = (TabLayout) view.findViewById(R.id.tb);
        vp = (ViewPager) view.findViewById(R.id.vp);
        sp = getActivity().getSharedPreferences("topic", Context.MODE_PRIVATE);
        initList();
        if (titleList.size() != 0) {
            MyPagerAdapter myadapter = new MyPagerAdapter(getChildFragmentManager(), mFragmentList, titleList);
            vp.setAdapter(myadapter);
            tb.setupWithViewPager(vp);
        } else {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.fg, new FragmentBlank()).commit();
        }


        return view;
    }

    public void initList() {
        Map<String,String> topicName = (Map<String, String>) sp.getAll();
        for (String key : topicName.keySet()) {
            titleList.add(key);
            mFragmentList.add(new FragmentRv(topicName.get(key)));

        }
    }

}
