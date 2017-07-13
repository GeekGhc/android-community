package com.gavin.community.mvp.ui.fragement;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gavin.community.R;
import com.gavin.community.app.Constants;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.mvp.adapter.HomeAdapter;
import com.gavin.community.mvp.adapter.HomePageAdapter;
import com.gavin.community.mvp.adapter.MyPagerAdapter;
import com.gavin.community.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends SimpleFragment {

    @BindView(R.id.tab_gold_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_gold_main)
    ViewPager mViewPager;

    private ArrayList<Fragment> mFragments;
//    List<HomePageFragment> fragments = new ArrayList<>();
    HomeAdapter mAdapter;
    HomePageFragment androidFragment;
    HomePageFragment iosFragment;
    HomePageFragment frontFragment;
    HomePageFragment backFragment;

    public static String[] type = new String[]{"Android", "iOS", "前端", "后端"};

    @Override
    protected int getLayoutId() {
        return R.layout.home_layout;
    }


    //初始化事件资源
    @Override
    protected void initEventAndData() {
        androidFragment = new HomePageFragment();
        iosFragment = new HomePageFragment();
        frontFragment = new HomePageFragment();
        backFragment = new HomePageFragment();

        Bundle androidBundle = new Bundle();
        androidBundle.putString(Constants.IT_TYPE, type[0]);
        androidBundle.putInt(Constants.IT_TYPE_CODE, Constants.TYPE_ANDROID);
        androidFragment.setArguments(androidBundle);

        Bundle iosBundle = new Bundle();
        androidBundle.putString(Constants.IT_TYPE, type[1]);
        androidBundle.putInt(Constants.IT_TYPE_CODE, Constants.TYPE_IOS);
        androidFragment.setArguments(iosBundle);

        Bundle frontBundle = new Bundle();
        androidBundle.putString(Constants.IT_TYPE, type[2]);
        androidBundle.putInt(Constants.IT_TYPE_CODE, Constants.TYPE_FRONT);
        androidFragment.setArguments(frontBundle);

        Bundle backBundle = new Bundle();
        androidBundle.putString(Constants.IT_TYPE, type[3]);
        androidBundle.putInt(Constants.IT_TYPE_CODE, Constants.TYPE_BACK);
        androidFragment.setArguments(backBundle);

        mFragments.add(androidFragment);
        mFragments.add(iosFragment);
        mFragments.add(frontFragment);
        mFragments.add(backFragment);
        mAdapter = new HomeAdapter(getChildFragmentManager(),mFragments);
        mViewPager.setAdapter(mAdapter);

        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        mTabLayout.addTab(mTabLayout.newTab().setText(type[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(type[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(type[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(type[3]));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(type[0]);
        mTabLayout.getTabAt(1).setText(type[1]);
        mTabLayout.getTabAt(2).setText(type[2]);
        mTabLayout.getTabAt(3).setText(type[3]);
    }



    //更新Tab
    /*@Override
    protected void initInject() {
       LogUtil.d("这是测试数据");
    }

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
        Intent intent = new Intent(getActivity(), HomeManagerActivity.class);
        intent.putExtra(Constants.IT_MANAGER, mBean);
        mContext.startActivity(intent);
    }*/

   /* private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : type) {
            mFragments.add(MainFragment.getInstance(title));
        }
    }*/

    /*private void initViewPager() {
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, type));
    }*/

}
