package com.gavin.community.mvp.ui.fragement;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gavin.community.R;
import com.gavin.community.app.Constants;
import com.gavin.community.common.base.RootFragment;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.common.base.contract.post.PostContract;
import com.gavin.community.component.ImageLoader;
import com.gavin.community.home.activity.PostDetailActivity;
import com.gavin.community.home.activity.TechDetailActivity;
import com.gavin.community.mvp.adapter.HomeAdapter;
import com.gavin.community.mvp.adapter.HomePageAdapter;
import com.gavin.community.mvp.adapter.MyPagerAdapter;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.presenter.Home.HomePagePresenter;
import com.gavin.community.utils.SystemUtil;
import com.gavin.community.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;


public class HomePageFragment extends SimpleFragment implements PostContract.View {

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

    List<PostItemBean> mList;
    MyPagerAdapter mAdapter;
    HomePagePresenter mPagePresenter;

    boolean isLoadingMore = false;
    String tech;
    int type;

    @Override
    protected int getLayoutId() {
        return R.layout.home_page_layout;
    }

    //初始化事件资源
    @Override
    protected void initEventAndData() {
        mList = new ArrayList<>();
        mPagePresenter = new HomePagePresenter();
        mPagePresenter.onTakeView(this);
        mPagePresenter.getPostData(tech, type);
        tech = getArguments().getString(Constants.IT_TYPE);
        type = getArguments().getInt(Constants.IT_TYPE_CODE);
        rvTechContent.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MyPagerAdapter(mContext, mList, tech);
        //设置每个item的点击事件
        mAdapter.setOnItemClickListener(new MyPagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View shareView) {
                PostDetailActivity.launch(new PostDetailActivity.Builder()
                        .setContext(mContext)
                        .setId(mList.get(position).getId())
                        .setTitle(mList.get(position).getTitle())
                        .setBody(mList.get(position).getBody())
                        .setType(type)
                        .setUserName(mList.get(position).getAuthor())
                        .setUserAvatar("avatar")
                        .setStarCount("23")
                        .setCommentCount("56")
                        .setFavoriteCount("12")
                        .setIsFavorite("true")
                        .setAnimConfig(mActivity, shareView)
                );
//                ToastUtil.show("body = " + mList.get(position).getAuthor());
            }
        });
        rvTechContent.setAdapter(mAdapter);

        //下拉加载更多
        rvTechContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) rvTechContent.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = rvTechContent.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {  //还剩2个Item时加载更多
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        mPagePresenter.getMorePostData(tech);
                    }
                }
            }
        });

        //设置appBar下拉的样式
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    swipeRefresh.setEnabled(true);
                } else {
                    swipeRefresh.setEnabled(false);
                    float rate = (float) (SystemUtil.dp2px(mContext, 256) + verticalOffset * 2) / SystemUtil.dp2px(mContext, 256);
                    if (rate >= 0)
                        ivOrigin.setAlpha(rate);
                }
            }
        });
        //设置下拉刷新事件
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPagePresenter.getPostData(tech, type);
            }
        });

        if (tech.equals(HomeFragment.type[0])) {
            ivBlur.setImageResource(R.drawable.bg_android);
        } else if (tech.equals(HomeFragment.type[1])) {
            ivBlur.setImageResource(R.drawable.bg_ios);
        } else if (tech.equals(HomeFragment.type[2])) {
            ivBlur.setImageResource(R.drawable.bg_js);
        } else if (tech.equals(HomeFragment.type[3])) {
            ivBlur.setImageResource(R.mipmap.bg_php);
        }
    }


    @Override
    public void stateError() {
        if (swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void showContent(List<PostItemBean> list) {
        if (swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        }
        stateMain();
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(List<PostItemBean> list) {
        stateMain();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
        isLoadingMore = false;
    }

    @Override
    public void showTypeImage(String url, String copyright) {
        ImageLoader.load(mContext, url, ivOrigin);
        Glide.with(mContext).load(url).bitmapTransform(new BlurTransformation(mContext)).into(ivBlur);
    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void stateMain() {

    }

    @Override
    public void stateEmpty() {

    }

}
