package com.gavin.community.myself.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.app.http.response.UserHttpResponse;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.common.entity.User;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.mvp.ui.activity.MainActivity;
import com.gavin.community.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class LoginActivity extends SimpleActivity {

    @BindView(R.id.register_activity)
    TextView mRegisterView;
    @BindView(R.id.toolbar_back)
    ImageView mToolbarBack;
    @BindView(R.id.forget_password_activity)
    TextView mResetPwd;
    @BindView(R.id.input_email)
    TextView mUserEmail;
    @BindView(R.id.input_password)
    TextView mUserPassword;
    @BindView(R.id.btn_login)
    AppCompatButton mLoginBtn;

    protected Retrofit mRetrofit;
    protected Retrofit.Builder mRetrofitBuilder;
    protected OkHttpClient mClient;
    UserAPI userService;
    private User cUser;


    private String email;
    private String password;


    @Override
    protected void initEventAndData() {
        prepareView();
        initData();
        initView();
        initListener();
    }

    @Override
    protected int getLayout() {
        return R.layout.login_layout;
    }

    //初始化数据
    private void initData() {
        mRetrofit = new HttpModule().provideUserRetrofit(mRetrofitBuilder, mClient);
        userService = mRetrofit.create(UserAPI.class);
    }

    private void initView() {

    }

    private void initListener() {
        mRegisterView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        mToolbarBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mResetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ResetPwdActivity.class);
                startActivity(intent);
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mUserEmail.getText().toString();
                password = mUserPassword.getText().toString();
                userService.login(email, password)
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

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    ToastUtil.show("社区君错误啦");
                                }
                            }
                        });
            }
        });
    }

    private void prepareView() {


    }
}
