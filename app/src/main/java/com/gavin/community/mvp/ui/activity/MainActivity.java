package com.gavin.community.mvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gavin.community.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAB_HOME_FRAGMENT = "home";
    private static final String TAB_MESSAGE_FRAGMENT = "message";
    private static final String TAB_DISCOVERY_FRAGMENT = "discovery";
    private static final String TAB_PROFILE_FRAGMENT = "profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //初始化数据
    private void initData()
    {

    }

    //初始化视图
    private void initView()
    {

    }
}
