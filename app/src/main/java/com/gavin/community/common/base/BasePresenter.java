package com.gavin.community.common.base;

/**
 * Created by Administrator on 2017/7/10.
 * Presenter基类
 */

public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
