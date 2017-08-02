package com.gavin.community.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.gavin.community.di.component.AppComponent;
import com.gavin.community.di.module.AppModule;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.utils.LogUtil;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

import java.util.LinkedList;
import java.util.List;


public class App extends Application implements Application.ActivityLifecycleCallbacks{

    private List<Activity> mActivityList = new LinkedList<Activity>();

    private static App instance;
    public static AppComponent appComponent;
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        UMShareAPI.get(this);
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    //签名:bd272a9ddc8ab3e631ec634798c83185
    {
        PlatformConfig.setAlipay("2017020805574567");
        PlatformConfig.setDing("ding120ecad352ad384635c2f4657eb6378f");
        PlatformConfig.setWeixin("wx0f48d00914bc89b3", "8cae9f9deaeea11867098bb7e0d55bfc");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setQQZone("1106243600", "DX0rs6pK6xQvxoxb");
        PlatformConfig.setSinaWeibo("4097375406","20954acac5b3f26a4f8c4777a401cd82","");//新浪微博 appkey appsecret
        PlatformConfig.setTwitter("FRhILwXfxnS29cocE4uIO0DpV", "1PDtwsd4bj6WJxgdShnkV4kBxXslh1yhrR7Q5UDvBJA2TLCyVj");
    }

    public static synchronized App getInstance()
    {
        return instance;
    }

    public void finishAll() {
        synchronized (mActivityList) {
            for (Activity activity : mActivityList) {
                    activity.finish();
            }
        }
    }

    public void recreateForNightMode() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing()) {
                activity.recreate();
            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        LogUtil.d("OnCreate = " + activity.getLocalClassName());
        mActivityList.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        LogUtil.d("OnDestroyed = " + activity.getLocalClassName());
        mActivityList.remove(activity);
    }

    public static AppComponent getAppComponent(){
        /*if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }*/
        return appComponent;
    }

}
