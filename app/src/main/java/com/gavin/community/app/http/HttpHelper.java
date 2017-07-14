package com.gavin.community.app.http;

import com.gavin.community.app.http.response.GankHttpResponse;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.GankSearchItemBean;
import com.gavin.community.mvp.model.bean.TestData;

import java.util.List;

import io.reactivex.Flowable;


public interface HttpHelper {

//    Flowable<TestData> getData(String name);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num);

    Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page);
}
