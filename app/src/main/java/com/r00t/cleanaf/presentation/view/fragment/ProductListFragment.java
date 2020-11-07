package com.r00t.cleanaf.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.r00t.cleanaf.R;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.presentation.presenter.ProductListPresenter;
import com.r00t.cleanaf.presentation.view.ProductListView;

import java.util.Collection;
import java.util.Objects;

import javax.inject.Inject;

public class ProductListFragment extends BaseFragment implements ProductListView {
    @Inject
    private ProductListPresenter productListPresenter;

    public interface ProductListListener {
        void onProductClicked(Product product);
    }

    private ProductListListener productListListener;

    public ProductListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() instanceof ProductListListener)
            productListListener = (ProductListListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xxx, container, false);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productListPresenter.setView(this);
        if (savedInstanceState == null)
            loadUserList();
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
        //TODO:
    }

    @Override
    public void onDetach() {
        super.onDetach();
        productListListener = null;
    }

    @Override
    public void renderProductList(Collection<Product> productCollection) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return Objects.requireNonNull(getActivity()).getApplicationContext();
    }

    private void setupRecyclerView() {

    }

    private void loadUserList() {

    }
}
