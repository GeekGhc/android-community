package com.gavin.community.common.base.contract;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.home.bean.PostListBean;

import java.util.List;


public class HomeContract {
    interface View extends BaseView {

        void showContent(List<PostListBean> goldListBean);

        void showMoreContent(List<PostListBean> goldMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getGoldData(String type);

        void getMoreGoldData();
    }
}
