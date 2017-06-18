package com.code4job.suny.stage1st.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.code4job.suny.stage1st.fragment.FragmentRv;
import com.code4job.suny.stage1st.fragment.FragmentTab;

import java.util.List;

/**
 * Created by suny on 2017/6/16.
 */

public class MHPgAdapter extends FragmentPagerAdapter {


    private List<FragmentTab> mFragmentRvs;
    private List<String> titleList;

    public MHPgAdapter(FragmentManager fm, List<FragmentTab> mFragmentRvs, List<String> titleList) {
        super(fm);
        this.mFragmentRvs = mFragmentRvs;
        this.titleList = titleList;

    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentRvs.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentRvs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}
