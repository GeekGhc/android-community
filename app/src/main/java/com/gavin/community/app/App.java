package com.gavin.community.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.gavin.community.di.component.AppComponent;
import com.gavin.community.di.module.AppModule;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.utils.LogUtil;

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

}
