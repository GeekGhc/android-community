package com.gavin.community.mvp.view;


import com.gavin.community.common.base.BaseView;
import com.gavin.community.mvp.model.bean.HomeManagerBean;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;
import com.gavin.community.mvp.ui.fragement.HomePageFragment;

import java.util.List;

public interface HomeFragmentView extends BaseView{

    void updateTab(List<HomeManagerItemBean> mList);

    void jumpToManager(HomeManagerBean mBean);
}
