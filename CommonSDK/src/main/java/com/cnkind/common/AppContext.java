package com.cnkind.common;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.cnkind.common.sdk.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * 基础Application
 *
 * @author txw
 * @date 2018/6/8
 */
public class AppContext extends Application {

    public final String TAG;

    protected Application application;
    protected Context context;

    public AppContext() {
        TAG = this.getClass().getSimpleName();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate");

        application = this;
        context = this;


        if (BuildConfig.DEBUG) {
            //debug版本
            Timber.plant(new Timber.DebugTree());
        } else {
            //release版本，打印关，同时gradle中的release的debuggable要设置为false
//            Timber.plant(new CrashReportingTree());
        }
        // CC组件化初始化
//        CC.enableVerboseLog(true);
//        CC.enableDebug(true);
//        CC.init(application);
//        CC.enableRemoteCC(true);

        // 友盟统计
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
//        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
//        UMConfigure.init(application, "AppKey", "Channel", UMConfigure.DEVICE_TYPE_PHONE, null);

        // 允许日志
//        UMConfigure.setLogEnabled(true);
//        // 日志加密
//        UMConfigure.setEncryptEnabled(true);
//        // 友盟debug模式
//        MobclickAgent.setDebugMode(true);
//        // 异常统计
//        MobclickAgent.setCatchUncaughtExceptions(true);
        // 上报统计
//        MobclickAgent.reportError();

        AppActivityLifecycleCallbacks appActivityLifecycleCallbacks = new AppActivityLifecycleCallbacks();

        registerActivityLifecycleCallbacks(appActivityLifecycleCallbacks);

        initLeakCanary();

    }

    public void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.i(TAG, "onLowMemory");

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.i(TAG, "onTerminate");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        Log.i(TAG, "onTrimMemory");
    }

//    @Override
//    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
//        super.registerActivityLifecycleCallbacks(callback);
//
//        Log.i(TAG, "registerActivityLifecycleCallbacks");
//    }
//
//    @Override
//    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
//        super.unregisterActivityLifecycleCallbacks(callback);
//
//        Log.i(TAG, "unregisterActivityLifecycleCallbacks");
//    }

    public boolean isDebug(Context context) {
        return context.getApplicationInfo() != null && (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

}
