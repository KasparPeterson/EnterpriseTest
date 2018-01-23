package com.kasparpeterson.enterprisetest.di.history;

import com.kasparpeterson.enterprisetest.ui.history.HistoryActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@Subcomponent(modules = HistoryActivityModule.class)
public interface HistoryActivityComponent extends AndroidInjector<HistoryActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HistoryActivity> {
    }

}
