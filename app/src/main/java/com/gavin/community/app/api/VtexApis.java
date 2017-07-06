package com.gavin.community.app.api;


import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 掘金api
 */

public interface VtexApis {

    String HOST = "https://www.v2ex.com/";

    String TAB_HOST = "https://www.v2ex.com/?tab=";

    String REPLIES_URL = "https://www.v2ex.com/t/";

}
