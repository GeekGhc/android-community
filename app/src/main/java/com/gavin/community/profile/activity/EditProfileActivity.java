package com.gavin.community.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.utils.ToastUtil;

import butterknife.BindView;

public class EditProfileActivity extends SimpleActivity {

    private Bundle bundle;
    @BindView(R.id.edit_toolbar_title)
    TextView mTextTitle;
    @BindView(R.id.toolbar_back)
    LinearLayout mGoBack;
    @BindView(R.id.edit_text)
    EditText mEditText;

    protected int getLayout()
    {
        return R.layout.user_edit_profile;
    }

    protected void initEventAndData() {
        prepareView();
        initListener();
    }

    protected void prepareView() {
        bundle = this.getIntent().getExtras();
        ToastUtil.show("title = "+bundle.getString("title"));
        mTextTitle.setText(bundle.getString("title"));
        mEditText.setText(bundle.getString("value"));
    }

    protected void initListener() {
        mGoBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
