package com.gavin.community.profile.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.app.http.response.UserHttpResponse;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.entity.User;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.mvp.ui.activity.MainActivity;
import com.gavin.community.myself.activity.LoginActivity;
import com.gavin.community.myself.activity.SettingActivity;
import com.gavin.community.myself.fragment.MySelfFragment;
import com.gavin.community.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class ProfileActivity extends SimpleActivity {


    @BindView(R.id.toolbar_back)
    ImageView mToolBarBack;
    @BindView(R.id.name)
    LinearLayout mNameLayout;
    @BindView(R.id.work)
    LinearLayout mWorkLayout;
    @BindView(R.id.city)
    LinearLayout mCityLayout;
    @BindView(R.id.desc)
    LinearLayout mDescLayout;
    @BindView(R.id.site)
    LinearLayout mSiteLayout;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.textCity)
    TextView textCity;
    @BindView(R.id.textDesc)
    TextView textDesc;
    @BindView(R.id.textWork)
    TextView textWork;
    @BindView(R.id.textSite)
    TextView textSite;

    protected Retrofit mRetrofit;
    protected Retrofit.Builder mRetrofitBuilder;
    protected OkHttpClient mClient;
    UserAPI userService;
    private User cUser;
    private String userId;


    protected int getLayout() {
        return R.layout.fragement_profile;
    }


    protected void initEventAndData() {
        prepareView();
        initData();
        initListener();
    }

    //视图准备
    private void prepareView() {
        mToolBarBack = (ImageView) findViewById(R.id.toolbar_back);
    }

    //初始化数据
    private void initData() {
        mRetrofit = new HttpModule().provideUserRetrofit(mRetrofitBuilder, mClient);
        userService = mRetrofit.create(UserAPI.class);
        SharedPreferences getUser = getSharedPreferences("user", Activity.MODE_PRIVATE);
        userId = getUser.getString("userId", "1");
        userService.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserHttpResponse<User>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(UserHttpResponse<User> userHttpResponse) {
                        if (userHttpResponse.getCode() == 1) {
                            cUser = userHttpResponse.getData();
                            setContent(cUser);
                        } else {
                            ToastUtil.show("社区君错误啦");
                        }
                    }
                });
        ToastUtil.show("user = " + cUser);
    }


    private void setContent(User user) {
        textName.setText(user.getName());
        textSite.setText(user.getSite());
        textDesc.setText(user.getDescription());
    }

    //初始化事件监听器
    private void initListener() {
        mToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "用户名");
                bundle.putString("value", textName.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mCityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "城市");
                bundle.putString("value", textCity.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mDescLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "个人简介");
                bundle.putString("value", textDesc.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mWorkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "职位");
                bundle.putString("value", textWork.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mSiteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "域名网站");
                bundle.putString("value", textSite.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
