package com.gavin.community.app;

import android.os.Environment;

import java.io.File;

public class Constants {

    //================= TYPE ====================
    public static final String IT_TYPE = "IT_type";
    public static final String IT_MANAGER = "IT_manager";
    public static final String IT_TYPE_CODE = "IT_type_code";

    public static final int TYPE_ANDROID = 101;
    public static final int TYPE_IOS = 102;
    public static final int TYPE_FRONT = 103;
    public static final int TYPE_BACK = 104;

    public static final String IT_GANK_DETAIL_TITLE = "gank_detail_title";

    public static final String IT_GANK_DETAIL_URL = "gank_detail_url";

    public static final String IT_GANK_DETAIL_IMG_URL = "gank_detail_img_url";

    public static final String IT_GANK_DETAIL_ID = "gank_detail_id";

    public static final String IT_GANK_DETAIL_TYPE = "gank_detail_type";


    //================= PATH ====================

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    //================= POST ====================
    public static final String IT_POST_ID= "post_id";
    public static final String IT_POST_TYPE = "post_type";
    public static final String IT_POST_TITLE = "post_title";
    public static final String IT_POST_BODY = "post_body";
    public static final String IT_POST_IS_FAVORITE = "post_is_favorite";
    public static final String IT_POST_USER_NAME = "post_user_name";
    public static final String IT_POST_USER_AVATAR = "post_user_avatar";
    public static final String IT_POST_COMMENT_COUNT = "post_comment_count";
    public static final String IT_POST_FAVORITE_COUNT = "post_favorite_count";
    public static final String IT_POST_STAR_COUNT = "post_star_count";
}
