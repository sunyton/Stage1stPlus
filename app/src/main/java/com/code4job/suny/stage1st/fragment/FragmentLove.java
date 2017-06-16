package com.code4job.suny.stage1st.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.adapter.MyPagerAdapter;
import com.code4job.suny.stage1st.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class FragmentLove extends Fragment {

    private TabLayout tb;
    private ViewPager vp;
    private List<FragmentRv> mFragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_love, container, false);

        tb = (TabLayout) view.findViewById(R.id.tb);
        vp = (ViewPager) view.findViewById(R.id.vp);
        mFragmentList.add(new FragmentRv(Constants.lolUrl));
        mFragmentList.add(new FragmentRv(Constants.game));
        mFragmentList.add(new FragmentRv(Constants.ct));
        mFragmentList.add(new FragmentRv(Constants.wenshi));
        mFragmentList.add(new FragmentRv(Constants.mobileUrl));
        mFragmentList.add(new FragmentRv(Constants.Pc));
        mFragmentList.add(new FragmentRv(Constants.mobileUrl));
        titleList.add("英雄联盟LOL");
        titleList.add("游戏论坛");
        titleList.add("动漫论坛");
        titleList.add("文史沙龙");
        titleList.add("手游页游");
        titleList.add("PC数码");
        titleList.add("影视论坛");
        MyPagerAdapter myadapter = new MyPagerAdapter(getFragmentManager(), mFragmentList, titleList);

        vp.setAdapter(myadapter);
        tb.setupWithViewPager(vp);

        return view;
    }
}
