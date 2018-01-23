package com.kasparpeterson.enterprisetest.di.domain;

import com.kasparpeterson.CounterStorage;
import com.kasparpeterson.CounterUseCase;
import com.kasparpeterson.LatestCounterUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */
@Module
public class UseCaseModule {

    @Provides
    CounterUseCase providesCounterUseCase(CounterStorage counterStorage) {
        return new CounterUseCase(counterStorage);
    }

    @Provides
    LatestCounterUseCase providesLatestCounterUseCase(CounterStorage counterStorage) {
        return new LatestCounterUseCase(counterStorage);
    }

}
