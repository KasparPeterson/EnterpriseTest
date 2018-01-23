package com.kasparpeterson;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */

public class LatestCounterUseCase {

    private final CounterStorage counterStorage;

    public LatestCounterUseCase(CounterStorage counterStorage) {
        this.counterStorage = counterStorage;
    }

    public int getLatestCounter() {
        return counterStorage.getCounter();
    }
}
