package com.gavin.community.common.base.contract.user;


import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.TestData;

public interface UserContract {

    interface View extends BaseView {

        void getName(TestData testData,String name);

    }

    interface Presenter extends BasePresenter<View> {


    }
}
