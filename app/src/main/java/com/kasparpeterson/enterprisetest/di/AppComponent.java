package com.kasparpeterson.enterprisetest.di;

import android.content.Context;

import com.kasparpeterson.enterprisetest.EnterpriseApplication;
import com.kasparpeterson.enterprisetest.di.data.StorageModule;
import com.kasparpeterson.enterprisetest.di.domain.UseCaseModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by kaspar.peterson on 13/10/2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBuilder.class,
        AndroidInjectionModule.class,
        UseCaseModule.class,
        StorageModule.class,
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

    void inject(EnterpriseApplication application);

}
