package com.gavin.community.profile.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gavin.community.R;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext;
    private ImageView mToolBarBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_profile);

        prepareView();
        initListener();
    }

    //视图准备
    private void prepareView() {
        mToolBarBack = (ImageView) findViewById(R.id.toolbar_back);
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
