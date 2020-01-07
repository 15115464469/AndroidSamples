package com.cnkind.common.di;

import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

/**
 * @author txw
 * @date 2018/9/14
 */
public abstract class BaseAppContext extends Application implements HasAndroidInjector {

    public final String TAG;
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;
    private static BaseAppContext appContext;
    private static BaseAppComponent baseAppComponent;

    public BaseAppContext() {
        TAG = BaseAppContext.class.getSimpleName();
    }

    public static BaseAppContext getInstance() {
        return appContext;
    }

    public static BaseAppComponent getAppComponent() {
        return baseAppComponent;
    }

    protected abstract void init();

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate()");

        super.onCreate();

        appContext = this;

        baseAppComponent = DaggerBaseAppComponent.builder().application(this).build();
        baseAppComponent.inject(this);

        init();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

}
