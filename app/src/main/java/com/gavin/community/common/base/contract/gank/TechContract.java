package com.gavin.community.common.base.contract.gank;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface TechContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> mList);

        void showMoreContent(List<GankItemBean> mList);

        void showGirlImage(String url, String copyright);
    }

    interface Presenter extends BasePresenter<View> {

        void getGankData(String tech, int type);

        void getMoreGankData(String tech);

        void getGirlImage();

    }
}
