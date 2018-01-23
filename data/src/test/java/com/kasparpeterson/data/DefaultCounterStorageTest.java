package com.kasparpeterson.data;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCounterStorageTest {

    @Mock
    private SharedPreferences preferences;

    @Mock(answer = Answers.RETURNS_SELF)
    private SharedPreferences.Editor editor;

    private DefaultCounterStorage storage;

    @Before
    public void setUp() throws Exception {
        when(preferences.edit()).thenReturn(editor);
        storage = new DefaultCounterStorage(preferences);
    }

    @Test
    public void saveCounter() throws Exception {
        storage.saveCounter(0);
        verify(preferences).edit();
        verify(editor).commit();
    }

    @Test
    public void getCounter() throws Exception {
        assertEquals(0, storage.getCounter());
    }

}