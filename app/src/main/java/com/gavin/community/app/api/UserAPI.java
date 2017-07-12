package com.gavin.community.app.api;

import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.model.bean.TestData;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI {

//    String HOST = "http://localhost:8000/api/";

    /**
     * 用户的基本信息
     */
    /*@GET("user/{userId}}")
    Call<User> getUser(@Path("userId") String userId);*/


    @GET("test/{name}")
    Call<TestData> getData(@Path("name") String name);

}
