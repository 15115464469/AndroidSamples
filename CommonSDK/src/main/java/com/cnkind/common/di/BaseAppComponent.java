package com.cnkind.common.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author txw
 * @date 2018/9/14
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,   // 普通组件
        AndroidSupportInjectionModule.class,  // support v4
        AppModule.class
})
public interface BaseAppComponent {

    Context context();

    @Component.Builder
    interface Builder {

        @BindsInstance
        BaseAppComponent.Builder application(Application application);

        BaseAppComponent build();

    }

    void inject(BaseAppContext appContext);

}
