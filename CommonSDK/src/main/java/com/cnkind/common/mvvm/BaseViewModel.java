package com.cnkind.common.mvvm;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.cnkind.common.AppExecutors;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author txw
 * @date 2018/9/25
 */
public class BaseViewModel<P> extends ViewModel {

    public static final String TAG = BaseViewModel.class.getSimpleName();

    @Inject
    SharedPreferences sp;
    @Inject
    AppExecutors mAppExecutors;
    protected P present;
    CompositeDisposable mCompositeDisposable;

    public void onClick(View view) {

    }

    public void setPresent(P present) {
        this.present = present;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        mCompositeDisposable.dispose();
        Log.i(TAG, "onCleared()");
    }

}
