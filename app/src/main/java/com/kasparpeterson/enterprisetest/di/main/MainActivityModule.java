package com.kasparpeterson.enterprisetest.di.main;

import com.kasparpeterson.CounterUseCase;
import com.kasparpeterson.enterprisetest.ui.main.MainActivity;
import com.kasparpeterson.enterprisetest.ui.main.MainPresenter;
import com.kasparpeterson.enterprisetest.ui.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kaspar.peterson on 13/10/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    MainView providesMainView(MainActivity activity) {
        return activity;
    }

    @Provides
    MainPresenter providesMainPresenter(MainView view, CounterUseCase counterUseCase) {
        return new MainPresenter(view, counterUseCase);
    }

}
