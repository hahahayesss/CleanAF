package com.r00t.cleanaf.presentation.view.activity;

import android.os.Bundle;
import android.widget.Button;

import com.r00t.cleanaf.R;
import com.r00t.cleanaf.presentation.view.fragment.ProductListFragment;

public class MainActivity extends BaseActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            addFragment(R.id.mainView, ProductListFragment.newInstance());
    }
}