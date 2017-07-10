package com.gavin.community.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class TouchSwipeRefreshLayout extends SwipeRefreshLayout {

    public TouchSwipeRefreshLayout(Context context) {
        super(context);
    }

    public TouchSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return isRefreshing() || super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isRefreshing() || super.onTouchEvent(ev);
    }
}
