package com.cnkind.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Activity生命周期回调
 *
 * @author txw
 * @date 2018/9/29
 */
@Singleton
public class AppActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    public static final String TAG = AppActivityLifecycleCallbacks.class.getSimpleName();


    FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks = new AppFragmentLifecycleCallbacks();

    private static List<Activity> activities = new ArrayList<>();
    private static WeakReference<Activity> currentActivity;

    public static void popAllActivity() {
        for (Activity mActy : activities) {
            mActy.finish();
        }
        if (currentActivity != null && currentActivity.get() != null){
            currentActivity.clear();
        }
        //System.exit(0);
    }

    public AppActivityLifecycleCallbacks() {
        activities = new ArrayList<>();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Timber.i("onActivityCreated：%s", activity.getComponentName());
        if (!activities.isEmpty() && activities.get(activities.size() - 1).getClass().getName().equals(activity.getClass().getName())) {
            Timber.i("重复打开Activity" + activity.getClass().getName() + "自动关闭重复Activity");
            activity.finish();
            return;
        }
        activities.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Timber.i("onActivityStarted：%s", activity.getComponentName());
        registerFragmentCallbacks(activity);
    }


    @Override
    public void onActivityResumed(Activity activity) {
        Timber.i("onActivityResumed：%s", activity.getComponentName());
        if(currentActivity != null){
            currentActivity.clear();
        }
        currentActivity = new WeakReference<>(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Timber.i("onActivityPaused：%s", activity.getComponentName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Timber.i("onActivityStopped：%s", activity.getComponentName());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Timber.i("onActivitySaveInstanceState：%s", activity.getComponentName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Timber.i("onActivityDestroyed：%s", activity.getComponentName());
        if (activities.isEmpty()) {
            return;
        }
        activities.remove(activity);
    }

    private void registerFragmentCallbacks(Activity activity) {
        boolean useFragment = activity instanceof BaseActivity;
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true);
        }
    }

    /**
     * 返回当前在前台的Activity
     * @return
     */
    public static Activity getCurrentActivity(){
        if (currentActivity == null || currentActivity.get() == null){
            return null;
        }else {
            return currentActivity.get();
        }
    }

}
