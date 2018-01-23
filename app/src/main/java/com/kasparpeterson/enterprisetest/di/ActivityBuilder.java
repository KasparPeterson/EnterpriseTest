package com.kasparpeterson.enterprisetest.di;

import android.app.Activity;

import com.kasparpeterson.enterprisetest.ui.history.HistoryActivity;
import com.kasparpeterson.enterprisetest.di.history.HistoryActivityComponent;
import com.kasparpeterson.enterprisetest.ui.main.MainActivity;
import com.kasparpeterson.enterprisetest.di.main.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by kaspar.peterson on 13/10/2017.
 */
@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(HistoryActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindHistoryActivity(HistoryActivityComponent.Builder builder);

}
