package com.kasparpeterson.enterprisetest.ui.history;

import android.support.annotation.NonNull;

import com.kasparpeterson.LatestCounterUseCase;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */

public class HistoryPresenter {

    @NonNull private final HistoryView view;
    @NonNull private final LatestCounterUseCase latestCounterUseCase;

    public HistoryPresenter(
            @NonNull HistoryView view,
            @NonNull LatestCounterUseCase latestCounterUseCase) {
        this.view = view;
        this.latestCounterUseCase = latestCounterUseCase;
    }

    // TODO: should be some base implementation?!?!
    public void onAttach() {
        view.showCounter(latestCounterUseCase.getLatestCounter());
    }
}
