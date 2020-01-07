package com.cnkind.common;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cnkind.common.mvp.IView;
import com.cnkind.common.sdk.R;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleObserver;

/**
 * 基础Activity
 *
 * @author txw
 * @date 2018/6/28
 */
public abstract class BaseActivity extends AppCompatActivity implements IView, View.OnClickListener {

    protected final String TAG;
    protected Context mContext;

    public BaseActivity() {
        TAG = this.getClass().getSimpleName();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        setContentView();

        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);

        // 监听生命周期
        LifecycleObserver lifecycleObserver = getLifecycleObserver();
        if (lifecycleObserver != null) {
            getLifecycle().addObserver(lifecycleObserver);
        }

        init();
    }

    protected void setContentView() {
        setContentView(getLayoutId());
    }

    /**
     * 初始化，可以根据业务重写init调整initView与intData先后顺序
     */
    @Override
    public void init() {
        initArguments();
        initView();

        initData();
    }

    @Override
    public abstract void initArguments();

    /**
     * 初始化生命周期监听
     *
     * @return LifecycleObserver生命周期观察者
     */
    @Override
    public LifecycleObserver getLifecycleObserver() {
        return null;
    }

    /**
     * 初始化布局
     *
     * @return 布局资源id
     */
    @Override
    public abstract int getLayoutId();

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

    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        MobclickAgent.onPageStart(this.getClass().getSimpleName());
//        MobclickAgent.onResume(mContext);
    }

    @Override
    protected void onPause() {
        super.onPause();

//        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
//        MobclickAgent.onPause(mContext);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 销毁数据
    }

}
