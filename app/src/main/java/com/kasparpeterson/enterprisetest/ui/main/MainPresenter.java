package com.kasparpeterson.enterprisetest.ui.main;

import android.support.annotation.NonNull;

import com.kasparpeterson.CounterUseCase;
import com.kasparpeterson.CounterUseCaseObserver;

import javax.inject.Inject;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */

public class MainPresenter implements CounterUseCaseObserver {

    @NonNull
    private final MainView view;

    @NonNull
    private final CounterUseCase counterUseCase;

    public MainPresenter(
            @NonNull MainView view,
            @NonNull CounterUseCase counterUseCase) {
        this.view = view;
        this.counterUseCase = counterUseCase;
        counterUseCase.setObserver(this);
    }

    public void onCounterClick() {
        counterUseCase.increment();
    }

    @Override
    public void onCounterChanged(int counter) {
        if (counter >= 20)
            view.showHistoryScreen();
        else
            view.showCounter(counter);
    }
}
