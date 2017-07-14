package com.gavin.community.common.base;

/**
 * Created by Administrator on 2017/7/10.
 * View 基类
 */

public interface BaseView {
    void showErrorMsg(String msg);

    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
