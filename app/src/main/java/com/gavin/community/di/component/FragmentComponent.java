package com.gavin.community.di.component;

import android.app.Activity;

import com.gavin.community.di.module.FragmentModule;
import com.gavin.community.di.scope.FragmentScope;

import dagger.Component;



@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

//    void inject(DailyFragment dailyFragment);
}
