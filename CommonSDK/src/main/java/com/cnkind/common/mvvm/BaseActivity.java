package com.cnkind.common.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import dagger.android.AndroidInjection;

/**
 * 基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends com.cnkind.common.BaseBindActivity<T> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

}
