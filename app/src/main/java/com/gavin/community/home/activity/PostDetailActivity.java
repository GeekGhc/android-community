package com.gavin.community.home.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;

import com.gavin.community.common.base.SimpleActivity;

import org.w3c.dom.Text;

import butterknife.BindView;

public class PostDetailActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.post_title)
    TextView tvPostTitle;
    @BindView(R.id.post_user_avatar)
    ImageView ivUserAvatar;
    @BindView(R.id.post_user_name)
    TextView tvUserName;
    @BindView(R.id.post_body)
    TextView tvPostBody;

    String title, body, id;
    int type;
    boolean isLiked;
    MenuItem menuItem;

    @Override
    protected int getLayout() {
        return R.layout.post_tech_detail;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu, menu);
        menuItem = menu.findItem(R.id.action_share);
        return true;
    }

    //设置是否收藏状态
    private void setLikeState(boolean state) {

    }

    public static class Builder {

        private String title;
        private String body;
        private String imgUrl;
        private String userName;
        private String userAvatar;
        private String id;
        private View shareView;
        private Context mContext;
        private Activity mActivity;

        public Builder() {

        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setContext(Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
            return this;
        }

        public Builder setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public Builder setAnimConfig(Activity mActivity, View shareView) {
            this.mActivity = mActivity;
            this.shareView = shareView;
            return this;
        }
    }

    public static void launch(Builder builder) {
        /*if (builder.shareView != null) {
            Intent intent = new Intent();
            intent.setClass(builder.mContext, TechDetailActivity.class);
            intent.putExtra(Constants.IT_GANK_DETAIL_URL, builder.url);
            intent.putExtra(Constants.IT_GANK_DETAIL_IMG_URL, builder.imgUrl);
            intent.putExtra(Constants.IT_GANK_DETAIL_TITLE, builder.title);
            intent.putExtra(Constants.IT_GANK_DETAIL_ID, builder.id);
            intent.putExtra(Constants.IT_GANK_DETAIL_TYPE, builder.type);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(builder.mActivity, builder.shareView, "shareView");
            builder.mContext.startActivity(intent,options.toBundle());
        } else {
            Intent intent = new Intent();
            intent.setClass(builder.mContext, TechDetailActivity.class);
            intent.putExtra(Constants.IT_GANK_DETAIL_URL, builder.url);
            intent.putExtra(Constants.IT_GANK_DETAIL_IMG_URL, builder.imgUrl);
            intent.putExtra(Constants.IT_GANK_DETAIL_TITLE, builder.title);
            intent.putExtra(Constants.IT_GANK_DETAIL_ID, builder.id);
            intent.putExtra(Constants.IT_GANK_DETAIL_TYPE, builder.type);
            builder.mContext.startActivity(intent);
        }*/
    }

}
