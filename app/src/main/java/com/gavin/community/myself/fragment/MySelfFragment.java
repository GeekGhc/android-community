package com.gavin.community.myself.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.gavin.community.R;
import com.gavin.community.common.entity.User;
import com.gavin.community.mvp.view.MeFragementView;
import com.gavin.community.myself.activity.SettingActivity;
import com.gavin.community.myself.favorite.activity.FavoriteActivity;
import com.gavin.community.myself.followers.activity.FollowersActivity;
import com.gavin.community.myself.following.activity.FollowingActivity;
import com.gavin.community.profile.activity.ProfileActivity;

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
