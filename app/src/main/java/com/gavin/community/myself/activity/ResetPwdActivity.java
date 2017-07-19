package com.gavin.community.myself.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.utils.ToastUtil;

import butterknife.BindView;

public class ResetPwdActivity extends SimpleActivity {

    @BindView(R.id.toolbar_back)
    LinearLayout mBackLayout;

    @Override
    protected int getLayout() {
        return R.layout.password_reset_layout;
    }

    @Override
    protected void initEventAndData() {
        initData();
        initView();
        initListener();
    }

    //初始化数据
    private void initData() {

    }

    private void initView() {

    }

    private void initListener() {
        mBackLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPwdActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
