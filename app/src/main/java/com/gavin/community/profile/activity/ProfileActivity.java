package com.gavin.community.profile.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.myself.activity.SettingActivity;
import com.gavin.community.myself.fragment.MySelfFragment;
import com.gavin.community.utils.ToastUtil;

import butterknife.BindView;

public class ProfileActivity extends SimpleActivity {

    private Context mContext;
    private ImageView mToolBarBack;

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


    private String name;
    protected String city;


    protected  int getLayout()
    {
        return R.layout.fragement_profile;
    }
    protected  void initEventAndData(){

        prepareView();
        initListener();
    }

    //视图准备
    private void prepareView() {
        mToolBarBack = (ImageView) findViewById(R.id.toolbar_back);
    }

    //初始化事件监听器
    private void initListener()
    {
        mToolBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mNameLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putString("title","用户名");
                bundle.putString("value",textName.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mCityLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putString("title","城市");
                bundle.putString("value",textCity.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mDescLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putString("title","个人简介");
                bundle.putString("value",textDesc.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mWorkLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putString("title","职位");
                bundle.putString("value",textWork.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mSiteLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                Bundle bundle =  new Bundle();
                bundle.putString("title","域名网站");
                bundle.putString("value",textSite.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
