package com.r00t.cleanaf.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.r00t.cleanaf.R;

public class ProductListActivity extends BaseActivity {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ProductListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        if (savedInstanceState == null)
            System.out.println();
    }
}
