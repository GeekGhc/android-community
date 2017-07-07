package com.gavin.community.myself.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gavin.community.R;

public class SettingActivity extends AppCompatActivity {

    private Context mContext;
    private LinearLayout mToolBarBack;
    private LinearLayout mExitLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_setting);
        mContext = this;
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
                                dialog.cancel();

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
