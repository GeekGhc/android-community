package com.gavin.community.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.TextView;
import com.gavin.community.R;

import com.gavin.community.common.base.SimpleActivity;

import butterknife.BindView;

public class PostDetailActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.wv_tech_content)
    WebView wvTechContent;
    @BindView(R.id.tv_progress)
    TextView tvProgress;

    String title,url,imgUrl,id;
    int type;
    boolean isLiked;

    @Override
    protected int getLayout() {
        return R.layout.activity_post_detail;
    }

    @Override
    protected void initEventAndData() {

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wvTechContent.canGoBack()) {
            wvTechContent.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
