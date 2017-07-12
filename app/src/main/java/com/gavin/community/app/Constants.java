package com.gavin.community.app;

import android.os.Environment;

import java.io.File;

public class Constants {

    //================= TYPE ====================
    public static final String IT_TYPE = "IT_type";
    public static final String IT_MANAGER = "IT_manager";


    //================= PATH ====================

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";


}
