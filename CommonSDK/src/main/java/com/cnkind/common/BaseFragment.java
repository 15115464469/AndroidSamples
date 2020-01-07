package com.cnkind.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.cnkind.common.mvp.IView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;

/**
 * 基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseFragment extends Fragment implements IView, View.OnClickListener {

    protected final String TAG;
    protected FragmentActivity mActivity;
    protected Context mContext;
    protected Bundle mBundle;
    protected View mRootView;

    public BaseFragment() {
        TAG = this.getClass().getSimpleName();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBundle = getArguments();
        if (mBundle != null) {
            initArguments();
        }

        this.mContext = getContext();
        this.mActivity = getActivity();

        // 监听Presenter生命周期
        LifecycleObserver lifecycleObserver = getLifecycleObserver();
        if (lifecycleObserver != null) {
            getLifecycle().addObserver(lifecycleObserver);
        }

    }

    /**
     * 初始化布局
     *
     * @return 布局资源id
     */
    @Override
    public abstract int getLayoutId();

    /**
     * 获取传递的参数值
     */
    @Override
    public abstract void initArguments();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);

        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    /**
     * 初始化，可以根据业务重写init调整initView与intData先后顺序
     */
    @Override
    public void init() {
        initView();

        initData();
    }

    /**
     * 获取生命周期观察者
     *
     * @return 生命周期观察者
     */
    @Override
    public LifecycleObserver getLifecycleObserver() {
        return null;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        // 初始化View
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        // 初始化数据
    }

    @Override
    public void onClick(View v) {

    }

    public void showToast(String content) {
        Toast.makeText(mActivity, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 销毁View
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 销毁
    }

}
