package com.r00t.cleanaf.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.r00t.cleanaf.R;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.presentation.presenter.ProductListPresenter;
import com.r00t.cleanaf.presentation.view.ProductListView;
import com.r00t.cleanaf.presentation.view.adapter.ProductAdapter;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProductListFragment extends BaseFragment implements ProductListView {
    @Inject
    protected ProductListPresenter productListPresenter;
    @Inject
    protected ProductAdapter productAdapter;

    private RecyclerView productListRecyclerView;
    private ProgressBar progressBar;
    private Button retryButton;

    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        // Bundle args = new Bundle();
        // args.putString("ARG_PARAM1", param1);
        // args.putString("ARG_PARAM2", param2);
        // fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        productListRecyclerView = view.findViewById(R.id.productListRecyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        retryButton = view.findViewById(R.id.retryButton);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productListPresenter.setView(this);
        if (savedInstanceState == null)
            productListPresenter.initialize();
        retryButton.setOnClickListener(v -> productListPresenter.initialize());
    }

    @Override
    public void onResume() {
        super.onResume();
        productListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        productListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        productListRecyclerView.setAdapter(null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        productListPresenter.destroy();
    }

    @Override
    public void showContent() {
        productListRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContent() {
        productListRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        retryButton.setVisibility(View.GONE);
    }

    @Override
    public void renderProductList(Collection<Product> productCollection) {
        productAdapter.setProductList((List<Product>) productCollection);
    }

    @Override
    public void showError(String message) {
        showToadMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    private void setupRecyclerView() {
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productListRecyclerView.setAdapter(productAdapter);
    }
}