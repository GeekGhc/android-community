package com.gavin.community.mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gavin.community.mvp.ui.fragement.HomePageFragment;

import java.util.List;

public class HomePageAdapter extends FragmentStatePagerAdapter {

    private List<HomePageFragment> fragments;

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
