package com.cnkind.common.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

/**
 * 基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends com.cnkind.common.BaseBindFragment<T> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

}
