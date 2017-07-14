package com.gavin.community.app.http;

import com.gavin.community.app.api.GankApis;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.app.http.response.GankHttpResponse;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.GankSearchItemBean;
import com.gavin.community.mvp.model.bean.TestData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/7/12.
 */

public class RetrofitHelper implements HttpHelper{
    private UserAPI userAPIService;
    private GankApis mGankApiService;

    @Inject
    public RetrofitHelper(UserAPI userAPIService){
        this.userAPIService = userAPIService;
    }

    /*@Override
    public Flowable<TestData> getData(String name)
    {
        return userAPIService.getData(name);
    }*/

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mGankApiService.getTechList(tech, num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mGankApiService.getGirlList(num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mGankApiService.getRandomGirl(num);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page) {
        return mGankApiService.getSearchList(query,type,num,page);
    }


}
