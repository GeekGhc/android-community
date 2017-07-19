package com.gavin.community.myself.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.app.api.PostAPI;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.home.post.fragment.PostSwipeActivity;

import butterknife.BindView;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RegisterActivity extends SimpleActivity {

    protected Retrofit mRetrofit;
    protected Retrofit.Builder mRetrofitBuilder;
    protected OkHttpClient mClient;
    UserAPI userService;

    @BindView(R.id.toolbar_back)
    ImageView mToolbarBack;
    @BindView(R.id.input_email)
    EditText mUserEmail;
    @BindView(R.id.input_password)
    EditText mUserPwd;
    @BindView(R.id.input_name)
    EditText mUserName;

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
        mRetrofit = new HttpModule().providePostRetrofit(mRetrofitBuilder, mClient);
        userService = mRetrofit.create(UserAPI.class);
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
