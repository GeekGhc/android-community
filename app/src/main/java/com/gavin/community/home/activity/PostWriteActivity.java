package com.gavin.community.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;

import butterknife.BindView;

public class PostWriteActivity extends SimpleActivity {

    @BindView(R.id.toolbar_back)
    ImageView ivBack;

    @Override
    protected int getLayout() {
        return R.layout.post_write;
    }

    @Override
    protected void initEventAndData() {

        setListener();
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
    }
}
