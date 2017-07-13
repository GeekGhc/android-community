package com.gavin.community.app.api;


import com.gavin.community.app.http.response.MyHttpResponse;
import com.gavin.community.mvp.model.bean.VersionBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MyAPI {

    String HOST = "http://kobeman.com/api/apk/";

    /**
     * 获取最新版本信息
     * @return
     */
    @GET("version")
    Flowable<MyHttpResponse<VersionBean>> getVersionInfo();
}
