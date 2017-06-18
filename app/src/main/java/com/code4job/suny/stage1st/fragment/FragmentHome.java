package com.code4job.suny.stage1st.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.adapter.MHPgAdapter;
import com.code4job.suny.stage1st.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/6/17.
 */

public class FragmentHome extends Fragment {


    private TabLayout homeLayout;
    private ViewPager homevp;
    private List<FragmentTab> mFragmentTabList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private String[] mStrings1;
    private String[] mStrings2;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homeLayout = (TabLayout) view.findViewById(R.id.hometl);
        homevp = (ViewPager) view.findViewById(R.id.homevp);
        mStrings1 = getActivity().getResources().getStringArray(R.array.topic);
        mStrings2 = getActivity().getResources().getStringArray(R.array.topic_new);

        mFragmentTabList.add(new FragmentTab(mStrings2));
        mFragmentTabList.add(new FragmentTab(mStrings1));
        titleList.add("新区");
        titleList.add("主论坛");

        homevp.setAdapter(new MHPgAdapter(getChildFragmentManager(), mFragmentTabList, titleList));
        homeLayout.setupWithViewPager(homevp);
        return view;
    }
}
