package com.gavin.community.discover.fragment;


import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.gavin.community.R;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.utils.ToastUtil;
import com.loonggg.rvbanner.lib.RecyclerViewBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class DiscoverFragment extends SimpleFragment {


    @BindView(R.id.rv_banner_1)
    RecyclerViewBanner recyclerViewBanner1;


    public int getLayoutId() {
        return R.layout.discover_layout;
    }

    public void initEventAndData() {
        initBanner();
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
               ToastUtil.show( "position: " + position);
            }
        });
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

}
