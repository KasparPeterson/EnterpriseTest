package com.kasparpeterson.enterprisetest.ui.history;

import com.kasparpeterson.LatestCounterUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoryPresenterTest {

    @Mock
    private HistoryView view;

    @Mock
    private LatestCounterUseCase useCase;

    private HistoryPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new HistoryPresenter(view, useCase);
    }

    @Test
    public void onAttach() throws Exception {
        Mockito.when(useCase.getLatestCounter()).thenReturn(13);
        presenter.onAttach();
        Mockito.verify(view).showCounter(13);
    }

}