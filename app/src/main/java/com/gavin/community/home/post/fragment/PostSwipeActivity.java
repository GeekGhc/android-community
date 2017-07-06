package com.gavin.community.home.post.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.gavin.community.R;

public class PostSwipeActivity extends AppCompatActivity {

    private Context mContext;
    private ImageView composePhoto;
    private ImageView composePost;
    private ImageView composeArticle;
    private ImageView composeLbs;
    private ImageView composeReview;
    private ImageView composeMore;
    private ImageView composeClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postfragment_layout);

        composePost = (ImageView) findViewById(R.id.compose_post);
        composePhoto = (ImageView) findViewById(R.id.compose_photo);
        composeArticle = (ImageView) findViewById(R.id.compose_articles);
        composeLbs = (ImageView) findViewById(R.id.compose_lbs);
        composeReview = (ImageView) findViewById(R.id.compose_review);
        composeMore = (ImageView) findViewById(R.id.compose_more);
        composeClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
