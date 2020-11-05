package com.r00t.cleanaf.presentation;

import android.os.Bundle;
import android.widget.Button;

import com.r00t.cleanaf.R;
import com.r00t.cleanaf.presentation.view.activity.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> navigator.navigateToProductsList(this));
    }
}