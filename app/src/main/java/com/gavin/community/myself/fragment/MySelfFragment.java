package com.gavin.community.myself.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.gavin.community.R;
import com.gavin.community.app.api.UserAPI;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.model.bean.TestData;
import com.gavin.community.mvp.view.MeFragementView;
import com.gavin.community.myself.activity.SettingActivity;
import com.gavin.community.myself.favorite.activity.FavoriteActivity;
import com.gavin.community.myself.followers.activity.FollowersActivity;
import com.gavin.community.myself.following.activity.FollowingActivity;
import com.gavin.community.profile.activity.ProfileActivity;

import butterknife.BindView;


public class MySelfFragment extends SimpleFragment implements MeFragementView {


    private ScrollView mScrollView;

    @BindView(R.id.setting_activity)
    LinearLayout mSettingActivity;
    @BindView(R.id.profile_activity)
    LinearLayout mProfileActivity;
    @BindView(R.id.followers_layout)
    LinearLayout mFollowersActivity;
    @BindView(R.id.following_layout)
    LinearLayout mFollowingActivity;
    @BindView(R.id.favorite_layout)
    LinearLayout mMyFavoriteActivity;
    @BindView(R.id.post_layout)
    LinearLayout mPostActivity;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.user_article_count)
    TextView mUserArticleCount;

    @Override
    protected int getLayoutId() {
        return R.layout.me_layout;
    }

    //初始化事件资源
    @Override
    protected void initEventAndData() {
        prepareView();
        initData();
        initListener();
    }


    public void prepareView() {
        mScrollView = (ScrollView) mView.findViewById(R.id.scrollview);
        mSettingActivity = (LinearLayout) mView.findViewById(R.id.setting_activity);
        mProfileActivity = (LinearLayout) mView.findViewById(R.id.profile_activity);
        mFollowersActivity = (LinearLayout) mView.findViewById(R.id.followers_layout);
        mFollowingActivity = (LinearLayout) mView.findViewById(R.id.following_layout);
        mMyFavoriteActivity = (LinearLayout) mView.findViewById(R.id.favorite_layout);
        mPostActivity = (LinearLayout) mView.findViewById(R.id.post_layout);
    }

    //返回这个fragment实例
    public static MySelfFragment newInstance() {
        MySelfFragment mySelfFragment = new MySelfFragment();
        return mySelfFragment;
    }


    //初始化fragment内容数据
    private void initData() {
        SharedPreferences getUser = this.getActivity().getSharedPreferences("user", Activity.MODE_PRIVATE);
        mUserName.setText(getUser.getString("name", "Jelly"));
    }

    //初始化组件监听器
    private void initListener() {
        mSettingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
        mProfileActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        mFollowersActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FollowersActivity.class));
            }
        });
        mFollowingActivity.setOnClickListener(new View.OnClickListener() {
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
        mPostActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
