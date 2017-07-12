package com.gavin.community.mvp.presenter;


import com.gavin.community.common.base.BaseView;
import com.gavin.community.common.base.RxPresenter;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;
import com.gavin.community.mvp.view.HomeFragmentView;

import io.realm.RealmList;

public class HomePresenter extends RxPresenter<HomeFragmentView> implements MainPresenter{
//    private RealmList<HomeManagerItemBean> mList;


    @Override
    public void initManagerList() {

    }

    @Override
    public void setManagerList()
    {

    }
    void stateError(){}

    void stateEmpty(){}

    void stateLoading(){}

    void stateMain(){}
}
