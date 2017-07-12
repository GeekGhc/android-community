package com.gavin.community.mvp.ui.fragement;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.mvp.adapter.MyPagerAdapter;
import com.gavin.community.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

public class HomeFragment extends SimpleFragment {

    @BindView(R.id.tab_gold_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_gold_main)
    ViewPager mViewPager;
   /* @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout mCoordinatorTabLayout;*/

    private ArrayList<Fragment> mFragments;
//    List<HomePageFragment> fragments = new ArrayList<>();
    private int currentIndex = 0;
    int[] mImageArray;

    public static String[] type = {"Android", "iOS", "前端", "后端", "设计", "产品", "阅读", "工具资源"};

    @Override
    protected int getLayoutId() {
        return R.layout.home_layout;
    }


    //初始化事件资源
    @Override
    protected void initEventAndData() {
        LogUtil.d("开始打印信息。。。");
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);

       /* initFragments();
        initViewPager();

        mImageArray = new int[]{
                R.drawable.bg_android,
                R.drawable.bg_ios,
                R.drawable.bg_js,
                R.drawable.bg_other};

        mCoordinatorTabLayout.setTitle("Demo")
                .setBackEnable(true)
                .setImageArray(mImageArray)
//                .setContentScrimColorArray(mColorArray)
                .setupWithViewPager(mViewPager);*/
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
