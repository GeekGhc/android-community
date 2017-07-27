package com.gavin.community.app.api;

import com.gavin.community.app.http.response.ArticleHttpResponse;
import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.mvp.model.bean.ArticleItemBean;
import com.gavin.community.mvp.model.bean.PostItemBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface ArticleAPI {

    String HOST = "http://10.0.3.2:8000/api/articles/";

    @GET("hot/list")
    Flowable<ArticleHttpResponse<List<ArticleItemBean>>> getHotList(@Query("type") String type, @Query("limit") int limit);
}
