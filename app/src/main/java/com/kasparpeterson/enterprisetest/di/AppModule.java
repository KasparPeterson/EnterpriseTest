package com.kasparpeterson.enterprisetest.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.kasparpeterson.enterprisetest.di.history.HistoryActivityComponent;
import com.kasparpeterson.enterprisetest.di.main.MainActivityComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kaspar.peterson on 13/10/2017.
 */
@Module(subcomponents = {
        MainActivityComponent.class,
        HistoryActivityComponent.class
})
public class AppModule {

    @Provides
    SharedPreferences sharedPreferences(Context context) {
        return context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
    }

}
