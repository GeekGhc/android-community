package com.gavin.community.mvp.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gavin.community.mvp.ui.fragement.HomePageFragment;

import java.util.List;

public class HomePageAdapter extends FragmentPagerAdapter {

    private List<HomePageFragment> fragments;
    private Context mContext;
    private String tabTitles[] = new String[]{"PHP","Android","IOS"};

    public HomePageAdapter(FragmentManager fm, List<HomePageFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
