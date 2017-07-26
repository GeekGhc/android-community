package com.gavin.community.home.post.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.home.post.fragment.EditorFragment;
import com.gavin.community.utils.ToastUtil;


import butterknife.BindView;

public class PostWriteActivity extends SimpleActivity {

    @BindView(R.id.toolbar_back)
    ImageView ivBack;
    @BindView(R.id.post_release)
    TextView tvPostPublish;

    private FragmentTransaction mTransaction;
    private FragmentManager mFragmentManager;
    private EditorFragment mWriteFragment;


    @Override
    protected int getLayout() {
        return R.layout.post_write;
    }

    @Override
    protected void initEventAndData() {
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        initData();
        setListener();
    }

    private void initData()
    {
        if(mWriteFragment == null){
            mWriteFragment = new EditorFragment();
            mTransaction.add(R.id.main_content,mWriteFragment);
        }else{
            mTransaction.show(mWriteFragment);
        }
        mTransaction.commit();
    }


    //设置一些监听事件
    private void setListener()
    {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvPostPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show("你已经成功发布了帖子");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWriteFragment = null;
    }
}
