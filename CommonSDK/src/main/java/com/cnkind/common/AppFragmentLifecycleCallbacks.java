package com.cnkind.common;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Fragment生命周期回调
 *
 * @author txw
 * @date 2018/9/29
 */
@Singleton
public class AppFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    public static final String TAG = AppFragmentLifecycleCallbacks.class.getSimpleName();

    public AppFragmentLifecycleCallbacks() {
    }

    private void logging(String method, Fragment fragment) {
        if (fragment.getClass().getSimpleName().contains("Dialog")) {
            // 对话框不打印
            return;
        }
        Timber.i(method, fragment.toString());
    }

    @Override
    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        logging("onFragmentAttached：%s", f);
    }

    @Override
    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        logging("onFragmentCreated：%s", f);
    }

    @Override
    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        logging("onFragmentViewCreated：%s", f);
    }

    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        logging("onFragmentStarted：%s", f);
    }

    @Override
    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        logging("onFragmentResumed：%s", f);
    }

    @Override
    public void onFragmentPaused(FragmentManager fm, Fragment f) {
        logging("onFragmentPaused：%s", f);
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        logging("onFragmentStopped：%s", f);
    }

    @Override
    public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
        logging("onFragmentViewDestroyed：%s", f);
    }

    @Override
    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        logging("onFragmentDestroyed：%s", f);
    }

    @Override
    public void onFragmentDetached(FragmentManager fm, Fragment f) {
        logging("onFragmentDetached：%s", f);
    }

}
