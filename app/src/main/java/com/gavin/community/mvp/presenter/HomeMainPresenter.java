package com.gavin.community.mvp.presenter;


import com.gavin.community.common.base.RxPresenter;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;
import com.gavin.community.mvp.view.HomeFragmentView;

import io.realm.RealmList;

public class HomeMainPresenter extends RxPresenter<HomeFragmentView> {
    private RealmList<HomeManagerItemBean> mList;

    private void initList() {
        mList = new RealmList<>();
        mList.add(new HomeManagerItemBean(0, true));
        mList.add(new HomeManagerItemBean(1, true));
        mList.add(new HomeManagerItemBean(2, true));
        mList.add(new HomeManagerItemBean(3, true));
        mList.add(new HomeManagerItemBean(4, false));
        mList.add(new HomeManagerItemBean(5, false));
        mList.add(new HomeManagerItemBean(6, false));
        mList.add(new HomeManagerItemBean(7, false));
    }
}
