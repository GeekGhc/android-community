package com.gavin.community.mvp.ui.fragement;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gavin.community.R;
import com.gavin.community.app.Constants;
import com.gavin.community.common.base.BaseFragment;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.home.activity.HomeManagerActivity;
import com.gavin.community.mvp.adapter.HomePageAdapter;
import com.gavin.community.mvp.model.bean.HomeManagerBean;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;
import com.gavin.community.mvp.presenter.HomePresenter;
import com.gavin.community.mvp.view.HomeFragmentView;
import com.gavin.community.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeFragmentView {

    private View mView;
    public RecyclerView mRecyclerView;
    public SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tab_gold_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_gold_main)
    ViewPager mViewPager;

    List<HomePageFragment> fragments = new ArrayList<>();
    private int currentIndex = 0;

    public static String[] type = {"PHP", "Android", "IOS", "前端", "后端", "产品", "阅读", "工具资源"};

    @Override
    protected int getLayoutId() {
        return R.layout.home_layout;
    }

    @Override
    protected void initInject() {
       LogUtil.d("这是测试数据");
    }
    //初始化事件资源
    @Override
    protected void initEventAndData() {
        LogUtil.d("开始打印信息。。。");
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //更新Tab
    @Override
    public void updateTab(List<HomeManagerItemBean> mList) {
        fragments.clear();
        mTabLayout.removeAllTabs();
        for (HomeManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                HomePageFragment fragment = new HomePageFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.IT_TYPE, type[item.getIndex()]);
                mTabLayout.addTab(mTabLayout.newTab().setText(type[item.getIndex()]));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
        }
        HomePageAdapter mAdapter = new HomePageAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        for (HomeManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                mTabLayout.getTabAt(currentIndex++).setText(type[item.getIndex()]);
            }
        }
        currentIndex = 0;

    }


    @Override
    public void jumpToManager(HomeManagerBean mBean) {
        /*Intent intent = new Intent(getActivity(), HomeManagerActivity.class);
        intent.putExtra(Constants.IT_MANAGER, mBean);
        mContext.startActivity(intent);*/
    }
}
