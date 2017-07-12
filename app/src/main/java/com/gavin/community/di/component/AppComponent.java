package com.gavin.community.di.component;

import com.gavin.community.app.App;
import com.gavin.community.di.module.AppModule;
import com.gavin.community.di.module.HttpModule;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context
}
