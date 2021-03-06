package com.gavin.community.mvp.presenter.Home;

import com.gavin.community.app.Constants;
import com.gavin.community.app.http.response.GankHttpResponse;
import com.gavin.community.common.base.RxPresenter;
import com.gavin.community.common.base.contract.gank.TechContract;
import com.gavin.community.mvp.model.DataManager;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.GankSearchItemBean;
import com.gavin.community.mvp.ui.fragement.HomeFragment;
import com.gavin.community.utils.RxUtil;
import com.gavin.community.widget.CommonSubscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

public class TechPresenter  extends RxPresenter<TechContract.View> implements TechContract.Presenter {

    private DataManager mDataManager;
    private static final int NUM_OF_PAGE = 6;

    private int currentPage = 0;
    private String queryStr = null;
    private String currentTech = HomeFragment.type[0];
    private int currentType = Constants.TYPE_ANDROID;

    @Inject
    public TechPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    /*@Override
    public void attachView(TechContract.View view) {
        super.attachView(view);
    }*/

    @Override
    public void getGankData(String tech, int type) {
        queryStr = null;
        currentPage = 0;
        currentTech = tech;
        currentType = type;
        addSubscribe(mDataManager.fetchTechList(tech,NUM_OF_PAGE,currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showContent(gankItemBeen);
                    }
                })
        );
    }

    @Override
    public void getMoreGankData(String tech) {
        if(queryStr != null) {
            getMoreSearchGankData();
            return;
        }
        addSubscribe(mDataManager.fetchTechList(tech,NUM_OF_PAGE,++currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView, "加载更多数据失败ヽ(≧Д≦)ノ", false) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showMoreContent(gankItemBeen);
                    }
                })
        );
    }

    private void getMoreSearchGankData() {
        addSubscribe(mDataManager.fetchGankSearchList(queryStr, currentTech, NUM_OF_PAGE, ++currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankSearchItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankSearchItemBean>>handleResult())
                .map(new Function<List<GankSearchItemBean>, List<GankItemBean>>() {
                    @Override
                    public List<GankItemBean> apply(List<GankSearchItemBean> gankSearchItemBeen) {
                        List<GankItemBean> newList = new ArrayList<>();
                        for (GankSearchItemBean item : gankSearchItemBeen) {
                            GankItemBean bean = new GankItemBean();
                            bean.set_id(item.getGanhuo_id());
                            bean.setDesc(item.getDesc());
                            bean.setPublishedAt(item.getPublishedAt());
                            bean.setWho(item.getWho());
                            bean.setUrl(item.getUrl());
                            newList.add(bean);
                        }
                        return newList;
                    }
                })
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView, false) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showMoreContent(gankItemBeen);
                    }
                })
        );
    }

    @Override
    public void getGirlImage() {
        addSubscribe(mDataManager.fetchRandomGirl(1)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView, "加载封面失败", false) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBean) {
                        mView.showGirlImage(gankItemBean.get(0).getUrl(), gankItemBean.get(0).getWho());
                    }
                })
        );
    }
}
