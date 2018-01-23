package com.kasparpeterson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterUseCaseTest {

    @Mock
    private CounterStorage storage;

    @Mock
    private CounterUseCaseObserver observer;

    private CounterUseCase useCase;

    @Before
    public void setUp() throws Exception {
        setUp(0);
    }

    private void setUp(int counter) {
        when(storage.getCounter()).thenReturn(counter);
        useCase = new CounterUseCase(storage);
        useCase.setObserver(observer);
    }

    @Test
    public void noIncrementCalled_observerNotCalled() {
        verify(observer, never()).onCounterChanged(anyInt());
    }

    @Test
    public void increment_observerCalledWith1() {
        useCase.increment();
        verify(observer).onCounterChanged(1);
    }

    @Test
    public void increment_storageHasCounterSaved_observerCalledWith2() {
        setUp(1);
        useCase.increment();
        verify(observer).onCounterChanged(2);
    }

    @Test
    public void increment_savesToStorage() {
        useCase.increment();
        verify(storage).saveCounter(1);
    }


}