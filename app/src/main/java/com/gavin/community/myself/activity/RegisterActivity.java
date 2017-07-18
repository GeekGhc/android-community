package com.gavin.community.myself.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.home.post.fragment.PostSwipeActivity;

import butterknife.BindView;

public class RegisterActivity extends SimpleActivity {

    @BindView(R.id.toolbar_back)
    ImageView mToolbarBack;

    @Override
    protected void initEventAndData() {
        prepareView();
        initData();
        initView();
        initListener();
    }

    @Override
    protected int getLayout() {
        return R.layout.register_layout;
    }

    //初始化数据
    private void initData() {

    }

    private void initView() {

    }

    private void initListener() {
        mToolbarBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void prepareView() {

    }
}
