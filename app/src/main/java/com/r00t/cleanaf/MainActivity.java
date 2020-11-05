package com.r00t.cleanaf;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.r00t.cleanaf.domain.repository.DataStore;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Inject
    protected DataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore.getAllProducts()
                .doOnNext(products -> products.forEach(product -> System.out.println(product.getId())));
    }
}