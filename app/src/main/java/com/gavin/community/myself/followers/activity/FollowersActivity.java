package com.gavin.community.myself.followers.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gavin.community.R;

public class FollowersActivity extends AppCompatActivity {

    private Context mContext;
    private LinearLayout mToolBarBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_followers_layout);
        prepareView();
        initListener();
    }

    //视图准备
    private void prepareView() {
        mToolBarBack = (LinearLayout) findViewById(R.id.toolbar_back);
    }

    //初始化事件监听器
    private void initListener()
    {
        mToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
