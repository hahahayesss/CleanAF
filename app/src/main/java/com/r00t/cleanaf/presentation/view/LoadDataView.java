package com.r00t.cleanaf.presentation.view;

import android.content.Context;

public interface LoadDataView {

    void showContent();

    void hideContent();

    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String message);

    Context context();
}
