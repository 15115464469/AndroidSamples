package com.cnkind.common;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.cnkind.common.mvp.IView;


/**
 * 基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseBindActivity<B extends ViewDataBinding> extends BaseActivity implements IView, View.OnClickListener {

    protected B mBinding;

    @Override
    protected void setContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

}
