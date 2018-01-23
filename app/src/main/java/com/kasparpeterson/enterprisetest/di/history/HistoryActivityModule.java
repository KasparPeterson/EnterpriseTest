package com.kasparpeterson.enterprisetest.di.history;

import com.kasparpeterson.LatestCounterUseCase;
import com.kasparpeterson.enterprisetest.ui.history.HistoryActivity;
import com.kasparpeterson.enterprisetest.ui.history.HistoryPresenter;
import com.kasparpeterson.enterprisetest.ui.history.HistoryView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@Module
public class HistoryActivityModule {

    @Provides
    HistoryView providesHistoryView(HistoryActivity activity) {
        return activity;
    }

    @Provides
    HistoryPresenter providesHistoryPresenter(HistoryView view, LatestCounterUseCase useCase) {
        return new HistoryPresenter(view, useCase);
    }

}
