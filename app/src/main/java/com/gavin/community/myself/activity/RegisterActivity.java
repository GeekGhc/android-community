package com.gavin.community.myself.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.app.http.response.UserHttpResponse;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.entity.User;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.home.post.fragment.PostSwipeActivity;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.model.bean.UserBean;
import com.gavin.community.mvp.ui.activity.MainActivity;
import com.gavin.community.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
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

    @BindView(R.id.btn_register)
    AppCompatButton mRegisterBtn;

    private String email;
    private String name;
    private String password;
    private User cUser;

    @Override
    protected void initEventAndData() {
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
        mRetrofit = new HttpModule().provideUserRetrofit(mRetrofitBuilder, mClient);
        userService = mRetrofit.create(UserAPI.class);
    }

    private void initView() {

    }

    private void initListener() {
        mToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mUserName.getText().toString();
                email = mUserEmail.getText().toString();
                password = mUserPwd.getText().toString();
                userService.register(email, name, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<UserHttpResponse<User>>() {
                            @Override
                            public void onSubscribe(Subscription s) {
                                s.request(Long.MAX_VALUE);
                            }
                            @Override
                            public void onComplete() {}
                            @Override
                            public void onError(Throwable e) {}
                            @Override
                            public void onNext(UserHttpResponse<User> userHttpResponse) {
                                if(userHttpResponse.getCode()==1){
                                    cUser = userHttpResponse.getData();
                                    SharedPreferences setUser = getSharedPreferences("user",Activity.MODE_PRIVATE);
                                    setUser.edit().putString("userId",cUser.getId()).commit();
                                    setUser.edit().putString("name",cUser.getName()).commit();

                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    ToastUtil.show("社区君错误啦");
                                }
                            }
                        });
            }
        });
    }

}
