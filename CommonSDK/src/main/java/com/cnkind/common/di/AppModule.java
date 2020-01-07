package com.cnkind.common.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.cnkind.common.AppExecutors;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Application Module
 *
 * @author txw
 * @date 2018/9/17
 */
@Module(includes = {NetworkModule.class, DBModule.class})
public abstract class AppModule {

    /**
     * 提供Context
     *
     * @param application Application
     * @return
     */
    @Binds
    abstract Context bindContext(Application application);

    /**
     * 提供SharedPreferences
     *
     * @param application
     * @return
     */
    @Provides
    public static SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("android_setting", Context.MODE_PRIVATE);
    }

    /**
     * 线程池
     */
    @Provides
    public static AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

}
