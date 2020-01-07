package com.cnkind.common.mvp;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 基础Activity Presenter
 *
 * @author txw
 * @date 2018/6/29
 */
public class BaseActivityPresent<V extends BaseContract.View> implements BasePresent, LifecycleObserver {

    /**
     * 日志TAG
     */
    protected final String TAG;
    /**
     * View引用
     */
    protected V view;

    public BaseActivityPresent(V view) {
        TAG = this.getClass().getSimpleName();
        this.view = view;
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner) {
        Log.i(TAG, "onCreate");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner owner) {
        Log.i(TAG, "onStart");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner owner) {
        Log.i(TAG, "onResume");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner owner) {
        Log.i(TAG, "onPause");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner owner) {
        Log.i(TAG, "onStop");
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner owner) {
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {
        Log.i(TAG, "onLifecycleChanged");
    }
}
