package com.kasparpeterson.enterprisetest.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kasparpeterson.CounterStorage;
import com.kasparpeterson.CounterUseCase;
import com.kasparpeterson.data.DefaultCounterStorage;
import com.kasparpeterson.enterprisetest.R;
import com.kasparpeterson.enterprisetest.ui.history.HistoryActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCounterClick();
            }
        });


        presenter = new MainPresenter(this, new CounterUseCase(new DefaultCounterStorage()))
    }

    @Override
    public void showCounter(int counter) {
        ((TextView) findViewById(R.id.text_view)).setText("Counter: " + counter);
    }

    @Override
    public void showHistoryScreen() {
        startActivity(HistoryActivity.getIntent(this));
    }
}
