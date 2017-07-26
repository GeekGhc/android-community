package com.gavin.community.app.api;

import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.model.bean.PostViewBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/7/13.
 */

public interface PostAPI {

    String HOST = "http://kobeman.com/api/posts/";

    @GET("list")
    Flowable<PostHttpResponse<List<PostItemBean>>> getPostList(@Query("type") String name, @Query("limit") int limit, @Query("page") int page);

    @GET("show/{id}")
    Flowable<PostHttpResponse<PostViewBean>> showPost(@Path("id") String id);

    @FormUrlEncoded
    @POST("create")
    Flowable<PostHttpResponse<PostItemBean>> releasePost(@Field("title") String title,@Field("tags") String tags,@Field("body") String body);

    @DELETE("remove")
    Flowable<PostHttpResponse<PostItemBean>> removePost(@Field("id") String id);

}
