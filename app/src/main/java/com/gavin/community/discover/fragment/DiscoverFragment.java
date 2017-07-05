package com.gavin.community.discover.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gavin.community.R;
import android.widget.RelativeLayout;

public class DiscoverFragment extends Fragment{
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.discover_layout, container, false);
        return mView;
    }
}
