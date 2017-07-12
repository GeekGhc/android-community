package com.gavin.community.home.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.gavin.community.R;

import com.gavin.community.app.Constants;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.mvp.adapter.HomeManagerAdapter;
import com.gavin.community.mvp.model.bean.HomeManagerBean;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;
import com.gavin.community.widget.DefaultItemTouchHelpCallback;

import java.util.Collections;

import butterknife.BindView;
import io.realm.RealmList;

public class HomeManagerActivity extends SimpleActivity{
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv_gold_manager_list)
    RecyclerView rvGoldManagerList;

    RealmList<HomeManagerItemBean> mList;
    HomeManagerAdapter mAdapter;
    DefaultItemTouchHelpCallback mCallback;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_manager;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(toolBar, "首页特别展示");
        mList = ((HomeManagerBean) getIntent().getParcelableExtra(Constants.IT_MANAGER)).getManagerList();
        mAdapter = new HomeManagerAdapter(mContext, mList);
        rvGoldManagerList.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoldManagerList.setAdapter(mAdapter);
        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mList != null) {
                    Collections.swap(mList, srcPosition, targetPosition);
                    mAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(rvGoldManagerList);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
