package com.gavin.community.myself.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.mvp.ui.activity.MainActivity;

public class SettingActivity extends SimpleActivity {

    private LinearLayout mToolBarBack;
    private LinearLayout mExitLayout;

    @Override
    protected int getLayout() {
        return R.layout.fragement_setting;
    }

    @Override
    protected void initEventAndData() {
        prepareView();
        initListener();
    }


    //视图准备
    private void prepareView() {
        mToolBarBack = (LinearLayout)findViewById(R.id.toolbar_back);
        mExitLayout = (LinearLayout)findViewById(R.id.exitLayout);
    }

    //初始化事件监听器
    private void initListener()
    {
        mExitLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("确定要退出微社区？")
                        .setCancelable(false)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences setUser = getSharedPreferences("user", Activity.MODE_PRIVATE);
                                setUser.edit().putString("userId","").commit();
                                setUser.edit().putString("name","").commit();
                                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        mToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
