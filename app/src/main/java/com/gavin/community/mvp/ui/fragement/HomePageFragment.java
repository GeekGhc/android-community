package com.gavin.community.mvp.ui.fragement;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import com.gavin.community.R;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.widget.TouchSwipeRefreshLayout;

import butterknife.BindView;



public class HomePageFragment extends SimpleFragment {

    @BindView(R.id.view_main)
    RecyclerView rvGoldList;
    @BindView(R.id.swipe_refresh)
    TouchSwipeRefreshLayout swipeRefresh;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    //初始化事件资源
    @Override
    protected void initEventAndData() {

    }
}
