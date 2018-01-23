package com.kasparpeterson.enterprisetest;

import com.kasparpeterson.CounterUseCase;
import com.kasparpeterson.enterprisetest.ui.main.MainPresenter;
import com.kasparpeterson.enterprisetest.ui.main.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView view;

    @Mock
    private CounterUseCase counterUseCase;

    private MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainPresenter(view, counterUseCase);
    }

    @Test
    public void constructor_setsObservableForCounterUseCase() {
        verify(counterUseCase).setObserver(presenter);
    }

    @Test
    public void onCounterClick_callsIncrement() throws Exception {
        presenter.onCounterClick();
        verify(counterUseCase).increment();
    }

    @Test
    public void onCounterChanged_showCounterCalled() {
        presenter.onCounterChanged(13);
        verify(view).showCounter(13);
    }

    @Test
    public void onCounterChanged_arrivesAt20_showHistory() {
        presenter.onCounterChanged(20);
        verify(view).showHistoryScreen();
    }

}