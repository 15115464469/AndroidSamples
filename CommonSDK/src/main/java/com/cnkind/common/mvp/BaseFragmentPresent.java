package com.cnkind.common.mvp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/**
 * 基础Fragment Presenter
 *
 * @author txw
 * @date 2018/6/29
 */
public class BaseFragmentPresent<V extends BaseContract.View> implements BasePresent{

    /**
     * 日志TAG
     */
    protected final String TAG;
    /**
     * 上下文
     */
    protected Context context;
    /**
     * View
     */
    protected V view;
    /**
     * setArgsments传递的参数
     */
    protected Bundle bundle;

    public BaseFragmentPresent(V view, Bundle bundle) {
        TAG = this.getClass().getSimpleName();
        this.view = view;
        context = ((Fragment) view).getContext();

        this.bundle = bundle;

    }

    @Override
    public void onCreate(LifecycleOwner owner) {
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause(LifecycleOwner owner) {
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop(LifecycleOwner owner) {
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy(LifecycleOwner owner) {
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {

    }
}
