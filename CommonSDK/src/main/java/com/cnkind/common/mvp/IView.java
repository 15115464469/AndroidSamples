package com.cnkind.common.mvp;


import androidx.lifecycle.LifecycleObserver;

/**
 * View
 *
 * @author txw
 * @date 2018/6/27
 */
public interface IView<T> {

    /**
     * 获取布局Id
     *
     * @return
     */
    int getLayoutId();

    /**
     * 获取生命周期观察者
     *
     * @return
     */
    LifecycleObserver getLifecycleObserver();

    /**
     * 界面初始化
     */
    void init();

    void initArguments();

    /**
     * 初始化View
     */
    void initView();

    /**
     * 初始化Data
     */
    void initData();

}
