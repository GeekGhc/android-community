package com.gavin.community.common.base.contract.article;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.ArticleItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface HotArticleContract {

    interface View extends BaseView {

        void showContent(List<ArticleItemBean> mList);

    }

    interface Presenter extends BasePresenter<HotArticleContract.View> {

        void  getHotArticleData();

    }
}
