package com.gavin.community.app.api;

import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.model.bean.PostViewBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface PostAPI {

    String HOST = "http://10.0.3.2:8000/api/posts/";

    @GET("list")
    Flowable<PostHttpResponse<List<PostItemBean>>> getPostList(@Query("type") String name, @Query("limit") int limit, @Query("page") int page);

    @GET("show/{id}")
    Flowable<PostHttpResponse<PostViewBean>> showPost(@Path("id") String id);
}
