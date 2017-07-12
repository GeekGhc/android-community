package com.gavin.community.mvp.presenter;

import com.gavin.community.common.base.BasePresenter;
import com.gavin.community.mvp.view.HomeFragmentView;


public interface MainPresenter extends BasePresenter<HomeFragmentView> {

    void initManagerList();

    void setManagerList();
}
