package com.kasparpeterson.enterprisetest.ui.history;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kasparpeterson.enterprisetest.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by kaspar.peterson on 14/10/2017.
 */

public class HistoryActivity extends AppCompatActivity implements HistoryView {

    public static Intent getIntent(@NonNull Context context) {
        return new Intent(context, HistoryActivity.class);
    }

    @Inject
    HistoryPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach();
    }

    @Override
    public void showCounter(int counter) {
        ((TextView) findViewById(R.id.history_counter_text_view)).setText("Latest: " + counter);
    }
}
