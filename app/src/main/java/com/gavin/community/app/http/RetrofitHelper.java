package com.gavin.community.app.http;

import com.gavin.community.app.api.UserAPI;
import com.gavin.community.mvp.model.bean.TestData;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/7/12.
 */

public class RetrofitHelper implements HttpHelper{
    private UserAPI userAPIService;

    @Inject
    public RetrofitHelper(UserAPI userAPIService){
        this.userAPIService = userAPIService;
    }

    /*@Override
    public Flowable<TestData> getData(String name)
    {
        return userAPIService.getData(name);
    }*/

}
