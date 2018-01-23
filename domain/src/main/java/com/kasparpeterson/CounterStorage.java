package com.kasparpeterson;

/**
 * Created by kaspar.peterson on 04/10/2017.
 */

public interface CounterStorage {

    void saveCounter(int counter);

    int getCounter();

}
