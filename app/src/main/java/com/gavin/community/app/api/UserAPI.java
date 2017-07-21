package com.gavin.community.app.api;

import com.gavin.community.app.http.response.UserHttpResponse;
import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.model.bean.TestData;
import com.gavin.community.mvp.model.bean.UserBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserAPI {

    String HOST = "http://kobeman.com/api/user/";

    /**
     * 用户的基本信息
     */
    /*@GET("user/{userId}}")
    Call<User> getUser(@Path("userId") String userId);*/

    @FormUrlEncoded
    @POST("test")
    Observable<TestData> getData(@Field("name") String name);

    /**
     * 获取用户
     */
    @GET("{userId}")
    Flowable<UserHttpResponse<User>> getUser(@Path("userId") String userId);

    /**
     * 用户注册
     */
    @FormUrlEncoded
    @POST("register")
    Flowable<UserHttpResponse<User>> register(@Field("email") String email, @Field("name") String name, @Field("password") String password);

    /**
     * 用户登录
     */
    @FormUrlEncoded
    @POST("login")
    Flowable<UserHttpResponse<User>> login(@Field("email") String email, @Field("password") String password);

    /**
     * 修改密码
     */
    @FormUrlEncoded
    @PATCH("pwd")
    Flowable<UserHttpResponse<String>> setPassword(@Field("password") String password);

    /**
     * 设置昵称
     */
    @FormUrlEncoded
    @PATCH("edit/name")
    Flowable<UserHttpResponse<String>> setName(@Field("name") String name);

    /**
     * 设置居住地
     */
    @FormUrlEncoded
    @PATCH("edit/location")
    Flowable<UserHttpResponse<String>> setLocation(@Field("location") String location);

    /**
     * 设置个人简介
     */
    @FormUrlEncoded
    @PATCH("edit/description")
    Flowable<UserHttpResponse<String>> setDesc(@Field("description") String description);

    /**
     * 设置个人网站
     */
    @FormUrlEncoded
    @PATCH("edit/description")
    Flowable<UserHttpResponse<String>> setSite(@Field("site") String site);


}
