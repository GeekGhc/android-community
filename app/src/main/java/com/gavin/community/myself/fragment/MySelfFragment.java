package com.gavin.community.myself.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.model.bean.TestData;
import com.gavin.community.mvp.view.MeFragementView;
import com.gavin.community.myself.activity.SettingActivity;
import com.gavin.community.myself.favorite.activity.FavoriteActivity;
import com.gavin.community.myself.followers.activity.FollowersActivity;
import com.gavin.community.myself.following.activity.FollowingActivity;
import com.gavin.community.profile.activity.ProfileActivity;
import com.gavin.community.utils.ToastUtil;
import com.google.common.eventbus.Subscribe;

import org.reactivestreams.Subscriber;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MySelfFragment extends Fragment implements MeFragementView {
    private View mView;
    private Activity mActivity;
    private Context mContext;
    private ScrollView mScrollView;
    private LinearLayout mSettingActivity;
    private LinearLayout mProfileActivity;
    private LinearLayout mFollowersActivity;
    private LinearLayout mFollowingActivity;
    private LinearLayout mMyFavoriteActivity;
    private LinearLayout mPostActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.me_layout, container, false);
        mScrollView = (ScrollView) mView.findViewById(R.id.scrollview);
        mSettingActivity = (LinearLayout) mView.findViewById(R.id.setting_activity);
        mProfileActivity = (LinearLayout)mView.findViewById(R.id.profile_activity);
        mFollowersActivity = (LinearLayout)mView.findViewById(R.id.followers_layout);
        mFollowingActivity = (LinearLayout)mView.findViewById(R.id.following_layout);
        mMyFavoriteActivity = (LinearLayout)mView.findViewById(R.id.favorite_layout);
        mPostActivity = (LinearLayout)mView.findViewById(R.id.post_layout);
        initData();
        initListener();
        return mView;
    }

    //返回这个fragment实例
    public static MySelfFragment newInstance() {
        MySelfFragment mySelfFragment = new MySelfFragment();
        return mySelfFragment;
    }


    //初始化fragment内容数据
    private void initData() {

    }

    //初始化组件监听器
    private void initListener() {
        mSettingActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
        mProfileActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        mFollowersActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FollowersActivity.class));
            }
        });
        mFollowingActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FollowingActivity.class));
            }
        });
        mMyFavoriteActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FavoriteActivity.class));
            }
        });
        mPostActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /*String url = "http://10.0.3.2:8000/api/";
                String name = "geekghc";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        //增加返回值为String的支持
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                UserAPI userAPI = retrofit.create(UserAPI.class);
                Call<TestData>call = userAPI.getData(name);
                call.enqueue(new Callback<TestData>() {
                    @Override
                    public void onResponse(Call<TestData> call, Response<TestData> response) {
                        String name = response.body().getName();
                        ToastUtil.show("name = "+name);
                    }
                    @Override
                    public void onFailure(Call<TestData> call, Throwable t) {
                        ToastUtil.show("failed = "+t.toString());
                    }
                });*/

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void setUserDetail(User user) {

    }

    @Override
    public void showScrollView() {
        mScrollView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideScrollView() {
        mScrollView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
