package com.gavin.community.mvp.ui.fragement;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.mvp.adapter.HomeAdapter;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.widget.TouchSwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;



public class HomePageFragment extends SimpleFragment {

    @BindView(R.id.view_main)
    RecyclerView rvTechContent;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.iv_tech_blur)
    ImageView ivBlur;
    @BindView(R.id.iv_tech_origin)
    ImageView ivOrigin;
    @BindView(R.id.tv_tech_copyright)
    TextView tvCopyright;
    @BindView(R.id.tech_appbar)
    AppBarLayout appbar;

    List<GankItemBean> mList;
    boolean isLoadingMore = false;
    String tech;


    HomeAdapter mAdpater;

    @Override
    protected int getLayoutId() {
        return R.layout.home_page_layout;
    }

    //初始化事件资源
    @Override
    protected void initEventAndData() {

    }
}
