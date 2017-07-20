package com.gavin.community.home.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;

import com.gavin.community.app.Constants;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.mvp.ui.activity.MainActivity;
import com.gavin.community.utils.SystemUtil;
import com.gavin.community.utils.ToastUtil;

import butterknife.BindView;

public class PostDetailActivity extends SimpleActivity {

    @BindView(R.id.post_view_toolbar)
    Toolbar toolBar;
    @BindView(R.id.post_title)
    TextView tvPostTitle;
    /*@BindView(R.id.post_user_avatar)
    ImageView ivUserAvatar;*/
    @BindView(R.id.post_user_name)
    TextView tvUserName;
    @BindView(R.id.post_body)
    TextView tvPostBody;
    @BindView(R.id.detail_bar_image)
    ImageView ivBarImg;

    String id, title, body, userName, userAvatar, commentCount, starCount, favoriteCount, isFavorite;
    int type;
    boolean isLiked;
    MenuItem menuItem;

    @Override
    protected int getLayout() {
        return R.layout.post_tech_detail;
    }

    @Override
    protected void initEventAndData() {
        Intent intent = getIntent();
        id = intent.getExtras().getString(Constants.IT_POST_ID);
        type = intent.getExtras().getInt(Constants.IT_POST_TYPE);
        title = intent.getExtras().getString(Constants.IT_POST_TITLE);
        body = intent.getExtras().getString(Constants.IT_POST_BODY);
        userName = intent.getExtras().getString(Constants.IT_POST_USER_NAME);
        userAvatar = intent.getExtras().getString(Constants.IT_POST_USER_AVATAR);
        isFavorite = intent.getExtras().getString(Constants.IT_POST_IS_FAVORITE);
        commentCount = intent.getExtras().getString(Constants.IT_POST_COMMENT_COUNT);
        favoriteCount = intent.getExtras().getString(Constants.IT_POST_FAVORITE_COUNT);
        starCount = intent.getExtras().getString(Constants.IT_POST_STAR_COUNT);
        setToolBar(toolBar, userName);
        tvUserName.setText(userName);
        tvPostTitle.setText(title);
        tvPostBody.setText(body);
        if(type == Constants.TYPE_ANDROID){
            ivBarImg.setImageResource(R.drawable.bg_android);
        }else if(type==Constants.TYPE_IOS){
            ivBarImg.setImageResource(R.drawable.bg_ios);
        }else if(type==Constants.TYPE_FRONT){
            ivBarImg.setImageResource(R.drawable.bg_js);
        }else if(type==Constants.TYPE_BACK){
            ivBarImg.setImageResource(R.drawable.bg_other);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu, menu);
        menuItem = menu.findItem(R.id.action_share);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_copy:
                SystemUtil.copyToClipBoard(mContext, "http://kobeman.com");
                return true;
            case R.id.action_share:
                ToastUtil.show("分享页面。。。。");

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            finishAfterTransition();
        }
    }

    //设置是否收藏状态
    private void setLikeState(boolean state) {

    }

    public static class Builder {

        private String id;
        private int type;
        private String title;
        private String body;
        private String userName;
        private String userAvatar;
        private String commentCount;
        private String starCount;
        private String favoriteCount;
        private String isFavorite;

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

        public Builder setType(int type) {
            this.type = type;
            return this;
        }

        public Builder setCommentCount(String commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public Builder setStarCount(String startCount) {
            this.starCount = startCount;
            return this;
        }

        public Builder setFavoriteCount(String favoriteCount) {
            this.favoriteCount = favoriteCount;
            return this;
        }

        public Builder setIsFavorite(String isFavorite) {
            this.isFavorite = isFavorite;
            return this;
        }

        public Builder setAnimConfig(Activity mActivity, View shareView) {
            this.mActivity = mActivity;
            this.shareView = shareView;
            return this;
        }
    }

    public static void launch(Builder builder) {
        if (builder.shareView != null) {
            Intent intent = new Intent();
            intent.setClass(builder.mContext, PostDetailActivity.class);
            intent.putExtra(Constants.IT_POST_ID, builder.id);
            intent.putExtra(Constants.IT_POST_TYPE, builder.type);
            intent.putExtra(Constants.IT_POST_TITLE, builder.title);
            intent.putExtra(Constants.IT_POST_BODY, builder.body);
            intent.putExtra(Constants.IT_POST_USER_NAME, builder.userName);
            intent.putExtra(Constants.IT_POST_USER_AVATAR, builder.userAvatar);
            intent.putExtra(Constants.IT_POST_COMMENT_COUNT, builder.commentCount);
            intent.putExtra(Constants.IT_POST_FAVORITE_COUNT, builder.favoriteCount);
            intent.putExtra(Constants.IT_POST_STAR_COUNT, builder.starCount);
            intent.putExtra(Constants.IT_POST_IS_FAVORITE, builder.isFavorite);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(builder.mActivity, builder.shareView, "shareView");
            builder.mContext.startActivity(intent,options.toBundle());
        } else {
            Intent intent = new Intent();
            intent.setClass(builder.mContext, PostDetailActivity.class);
            intent.putExtra(Constants.IT_POST_ID, builder.id);
            intent.putExtra(Constants.IT_POST_TITLE, builder.title);
            intent.putExtra(Constants.IT_POST_BODY, builder.body);
            intent.putExtra(Constants.IT_POST_USER_NAME, builder.userName);
            intent.putExtra(Constants.IT_POST_USER_AVATAR, builder.userAvatar);
            intent.putExtra(Constants.IT_POST_COMMENT_COUNT, builder.commentCount);
            intent.putExtra(Constants.IT_POST_FAVORITE_COUNT, builder.favoriteCount);
            intent.putExtra(Constants.IT_POST_STAR_COUNT, builder.starCount);
            intent.putExtra(Constants.IT_POST_IS_FAVORITE, builder.isFavorite);
            builder.mContext.startActivity(intent);
        }
    }

}
