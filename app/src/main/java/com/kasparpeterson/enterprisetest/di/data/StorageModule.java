package com.kasparpeterson.enterprisetest.di.data;

import android.content.SharedPreferences;

import com.kasparpeterson.CounterStorage;
import com.kasparpeterson.data.DefaultCounterStorage;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@Module
public class StorageModule {

    @Provides
    CounterStorage providesCounterStorage(SharedPreferences sharedPreferences) {
        return new DefaultCounterStorage(sharedPreferences);
    }

}
