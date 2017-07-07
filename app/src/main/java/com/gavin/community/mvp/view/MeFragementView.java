package com.gavin.community.mvp.view;

import android.support.v4.app.Fragment;

import com.gavin.community.common.entity.User;


public interface MeFragementView {

    public void setUserDetail(User user);

    public void showScrollView();

    public void hideScrollView();
}
