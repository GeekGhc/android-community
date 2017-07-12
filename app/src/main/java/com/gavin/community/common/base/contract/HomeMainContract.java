package com.gavin.community.common.base.contract;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.HomeManagerBean;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */

public interface HomeMainContract {
    interface View extends BaseView {

        void updateTab(List<HomeManagerItemBean> mList);

        void jumpToManager(HomeManagerBean mBean);
    }

    interface Presenter extends BasePresenter<View> {

        void initManagerList();

        void setManagerList();
    }
}
