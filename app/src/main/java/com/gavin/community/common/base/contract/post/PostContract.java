package com.gavin.community.common.base.contract.post;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.PostItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */

public interface PostContract {
    interface View extends BaseView {

        void showContent(List<PostItemBean> mList);

        void showMoreContent(List<PostItemBean> mList);

        void showGirlImage(String url, String copyright);
    }

    interface Presenter extends BasePresenter<View> {

        void getPostData(String tech, int type);

        void getMorePostData(String tech);

        void getTypeImage(String tech);

    }
}
