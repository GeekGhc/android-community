package com.gavin.community.message.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gavin.community.R;

public class MessageFragment extends Fragment{
    private Activity mActivity;
    private View mToolBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View mView;
    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragement_profile, container, false);
        mActivity = getActivity();
//        mContext = getContext();
        return mView;
    }
}
