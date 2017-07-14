package com.gavin.community.mvp.model;

import com.gavin.community.app.db.DBHelper;
import com.gavin.community.app.http.HttpHelper;
import com.gavin.community.app.http.response.GankHttpResponse;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.GankSearchItemBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DataManager implements HttpHelper, DBHelper {
    HttpHelper mHttpHelper;
    DBHelper mDbHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
    }

    @Override
    public  boolean queryPostId(int id){
        return true;
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mHttpHelper.fetchTechList(tech, num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mHttpHelper.fetchGirlList(num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mHttpHelper.fetchRandomGirl(num);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page) {
        return mHttpHelper.fetchGankSearchList(query, type, num, page);
    }
}
