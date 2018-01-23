package com.kasparpeterson;

public class CounterUseCase {

    private final CounterStorage storage;

    private CounterUseCaseObserver observer;

    public CounterUseCase(CounterStorage storage) {
        this.storage = storage;
    }

    public void increment() {
        int counter = storage.getCounter();
        counter++;
        storage.saveCounter(counter);

        if (observer != null) observer.onCounterChanged(counter);
    }

    public void setObserver(CounterUseCaseObserver observer) {
        this.observer = observer;
    }
}
