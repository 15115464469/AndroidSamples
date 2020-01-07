package com.cnkind.common.mvp;


import androidx.lifecycle.LifecycleObserver;

/**
 * MVP架构基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseActivity<P extends BaseContract.Present> extends com.cnkind.common.BaseActivity {

    protected P mPresent;

    /**
     * 初始化，可以根据业务重写init调整initView与intData先后顺序
     */
    @Override
    public void init() {
        // 创建Presenter
        mPresent = newPresent();

        super.init();
    }

    /**
     * 初始化Present
     *
     * @return
     */
    protected abstract P newPresent();

    @Override
    public LifecycleObserver getLifecycleObserver() {
        return (LifecycleObserver) mPresent;
    }

}
