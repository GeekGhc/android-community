package com.gavin.community.mvp.ui.fragement;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gavin.community.R;
import com.gavin.community.app.Constants;
import com.gavin.community.common.base.RootFragment;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.common.base.contract.gank.TechContract;
import com.gavin.community.component.ImageLoader;
import com.gavin.community.home.activity.TechDetailActivity;
import com.gavin.community.mvp.adapter.HomeAdapter;
import com.gavin.community.mvp.adapter.HomePageAdapter;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.presenter.Home.TechPresenter;
import com.gavin.community.utils.LogUtil;
import com.gavin.community.utils.SystemUtil;
import com.gavin.community.utils.ToastUtil;
import com.gavin.community.widget.TouchSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;


public class HomePageFragment extends SimpleFragment{

    @BindView(R.id.view_main)
    RecyclerView rvTechContent;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.iv_tech_blur)
    ImageView ivBlur;
    @BindView(R.id.iv_tech_origin)
    ImageView ivOrigin;
    @BindView(R.id.tech_appbar)
    AppBarLayout appbar;

    List<GankItemBean> mList;
    HomePageAdapter mAdapter;

    boolean isLoadingMore = false;
    String tech;
    int type;

    @Override
    protected int getLayoutId() {
        return R.layout.home_page_layout;
    }

    /*@Override
    protected void initInject() {
    }*/

    //初始化事件资源
    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        tech = getArguments().getString(Constants.IT_TYPE);
        ToastUtil.show("data = "+tech);
        /*tech = getArguments().getString(Constants.IT_TYPE);
        type = getArguments().getInt(Constants.IT_TYPE_CODE);*/
        /*mAdapter = new HomePageAdapter(mContext,mList,tech);
        rvTechContent.setLayoutManager(new LinearLayoutManager(mContext));
        stateLoading();
        rvTechContent.setAdapter(mAdapter);
        mPresenter.getGankData(tech, type);
        mAdapter.setOnItemClickListener(new HomePageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View shareView) {
                TechDetailActivity.launch(new TechDetailActivity.Builder()
                        .setContext(mContext)
                        .setId(mList.get(position).get_id())
                        .setTitle(mList.get(position).getDesc())
                        .setUrl(mList.get(position).getUrl())
                        .setType(type)
                        .setAnimConfig(mActivity, shareView));
            }
        });
        rvTechContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) rvTechContent.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = rvTechContent.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {  //还剩2个Item时加载更多
                    if(!isLoadingMore){
                        isLoadingMore = true;
                        mPresenter.getMoreGankData(tech);
                    }
                }
            }
        });
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    swipeRefresh.setEnabled(true);
                } else {
                    swipeRefresh.setEnabled(false);
                    float rate = (float)(SystemUtil.dp2px(mContext, 256) + verticalOffset * 2) / SystemUtil.dp2px(mContext, 256);
                    if (rate >= 0)
                        ivOrigin.setAlpha(rate);
                }
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getGankData(tech, type);
            }
        });*/

    }


    private void setListener(){
        //swipeRefreshLayout刷新监听
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }


    /*@Override
    public void stateError() {
        super.stateError();
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }*/

    /*@Override
    public void showContent(List<GankItemBean> list) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
        stateMain();
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }*/

  /*  @Override
    public void showMoreContent(List<GankItemBean> list) {
        stateMain();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
        isLoadingMore = false;
    }*/

  /*  @Override
    public void showGirlImage(String url, String copyright) {
        ImageLoader.load(mContext, url, ivOrigin);
        Glide.with(mContext).load(url).bitmapTransform(new BlurTransformation(mContext)).into(ivBlur);
        tvCopyright.setText(String.format("by: %s",copyright));
    }*/
}
