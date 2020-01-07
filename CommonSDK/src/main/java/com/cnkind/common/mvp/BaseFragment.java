package com.cnkind.common.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;

/**
 * MVP架构基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseFragment<P extends BaseContract.Present> extends com.cnkind.common.BaseFragment {

    protected P mPresent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建Presenter
        mPresent = newPresent(this, mBundle);
    }

    protected abstract P newPresent(BaseFragment<P> baseFragment, Bundle bundle);

    @Override
    public LifecycleObserver getLifecycleObserver() {
        return (LifecycleObserver) mPresent;
    }

}
