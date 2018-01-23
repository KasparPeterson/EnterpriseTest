package com.kasparpeterson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LatestCounterUseCaseTest {

    @Mock
    private CounterStorage storage;

    private LatestCounterUseCase useCase;

    @Before
    public void setUp() {
        useCase = new LatestCounterUseCase(storage);
    }

    @Test
    public void getLatestCounter() {
        assertEquals(0, useCase.getLatestCounter());
    }

    @Test
    public void getLatestCounter_storage() {
        when(storage.getCounter()).thenReturn(13);
        assertEquals(13, useCase.getLatestCounter());
    }

}