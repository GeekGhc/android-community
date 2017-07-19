package com.gavin.community.app.api;

import com.gavin.community.app.http.response.UserHttpResponse;
import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.model.bean.TestData;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPI {

    String HOST = "http://10.0.3.2:8000/api/";

    /**
     * 用户的基本信息
     */
    /*@GET("user/{userId}}")
    Call<User> getUser(@Path("userId") String userId);*/

    @FormUrlEncoded
    @POST("test")
    Observable<TestData> getData(@Field("name") String name);

    /**
     * 用户注册
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<UserHttpResponse> register(@Field("email") String email, @Field("name") String name, @Field("password") String password);

    /**
     * 用户登录
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserHttpResponse> register(@Field("email") String email,@Field("password") String password);

}
