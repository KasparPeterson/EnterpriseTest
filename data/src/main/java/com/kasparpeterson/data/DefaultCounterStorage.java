package com.kasparpeterson.data;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.kasparpeterson.CounterStorage;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */

public class DefaultCounterStorage implements CounterStorage {

    private final String COUNTER = "arg_counter";

    @NonNull
    private final SharedPreferences preferences;

    public DefaultCounterStorage(@NonNull SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @SuppressLint("ApplySharedPref")
    @Override
    public void saveCounter(int counter) {
        preferences.edit().putInt(COUNTER, counter).commit();
    }

    @Override
    public int getCounter() {
        return preferences.getInt(COUNTER, 0);
    }
}
