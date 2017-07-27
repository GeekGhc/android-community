package com.gavin.community.discover.fragment;


import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.gavin.community.R;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.common.base.contract.article.HotArticleContract;
import com.gavin.community.mvp.adapter.MyPagerAdapter;
import com.gavin.community.mvp.adapter.discover.HotArticleAdapter;
import com.gavin.community.mvp.model.bean.ArticleItemBean;
import com.gavin.community.mvp.presenter.Discover.HotArticlePresenter;
import com.gavin.community.utils.ToastUtil;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class DiscoverFragment extends SimpleFragment implements HotArticleContract.View{


    @BindView(R.id.rv_banner_1)
    RecyclerViewBanner recyclerViewBanner1;
    @BindView(R.id.rv_article)
    RecyclerView rvHotArticle;

    HotArticleAdapter mAdapter;
    List<ArticleItemBean> mList;
    HotArticlePresenter mPresenter;
    private String type = "PHP";



    public int getLayoutId() {
        return R.layout.discover_layout;
    }

    public void initEventAndData() {
        initBanner();
        mList = new ArrayList<>();
        mPresenter  = new HotArticlePresenter(type);
        mPresenter.onTakeView(this);
        mPresenter.getHotArticleData();
        mAdapter = new HotArticleAdapter(mContext, mList);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHotArticle.setLayoutManager(linearLayoutManager);
        mAdapter.setOnItemClickListener(new HotArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View shareView) {

            }
        });
        rvHotArticle.setAdapter(mAdapter);
    }

    private void initBanner() {
        final List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("https://ol7nwmu54.qnssl.com/community/banner/bg_ios.jpg"));
        banners.add(new Banner("https://ol7nwmu54.qnssl.com/community/banner/poster.jpg"));
        banners.add(new Banner("https://ol7nwmu54.qnssl.com/community/banner/bg_android.jpg"));
        banners.add(new Banner("https://ol7nwmu54.qnssl.com/community/banner/bg_js.jpg"));
        banners.add(new Banner("https://ol7nwmu54.qnssl.com/community/banner/bg_other.jpg"));

        recyclerViewBanner1.setRvBannerData(banners);
        recyclerViewBanner1.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                Glide.with(bannerView.getContext())
                        .load(banners.get(position).getUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(bannerView);
            }
        });
        recyclerViewBanner1.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }

    @Override
    public void showContent(List<ArticleItemBean> list)
    {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
    private class Banner {
        String url;
        public Banner(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }
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
    @Override
    public void stateError() {

    }

}
