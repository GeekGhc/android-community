package com.gavin.community.home.activity;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.gavin.community.R;

import com.gavin.community.common.base.SimpleActivity;

import butterknife.BindView;

public class HomeManagerActivity extends SimpleActivity{
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv_gold_manager_list)
    RecyclerView rvGoldManagerList;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_manager;
    }

    @Override
    protected void initEventAndData() {
//        setToolBar(toolBar, "首页特别展示");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
