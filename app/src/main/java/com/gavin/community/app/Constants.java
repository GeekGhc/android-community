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
    public static final int TYPE_PHP = 105;


    //================= PATH ====================

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";


}
