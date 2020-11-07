package com.r00t.cleanaf.presentation.presenter;

import com.r00t.cleanaf.domain.exception.DefaultErrorBundle;
import com.r00t.cleanaf.domain.exception.ErrorBundle;
import com.r00t.cleanaf.domain.interactor.GetProductList;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.presentation.exception.ErrorMessageFactory;
import com.r00t.cleanaf.presentation.internal.di.DefaultObserver;
import com.r00t.cleanaf.presentation.view.ProductListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class ProductListPresenter implements Presenter {
    private GetProductList getProductList;
    private ProductListView view;

    @Inject
    public ProductListPresenter(GetProductList getProductList) {
        this.getProductList = getProductList;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        getProductList.dispose();
        view = null;
    }

    public void setView(ProductListView view) {
        this.view = view;
    }

    public void initialize() {
        loadProductList();
    }

    private void loadProductList() {
        hideViewRetry();
        showViewLoading();
        getProductList();
    }

    private void showViewLoading() {
        view.showLoading();
    }

    private void hideViewLoading() {
        view.hideLoading();
    }

    private void showViewRetry() {
        view.showRetry();
    }

    private void hideViewRetry() {
        view.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    private void showProductsCollectionView(Collection<Product> productCollection) {
        view.renderProductList(productCollection);
    }

    private void getProductList() {
        getProductList.execute(new ProductListObserver(), null);
    }

    private class ProductListObserver extends DefaultObserver<List<Product>> {

        @Override
        public void onComplete() {
            hideViewLoading();
        }

        @Override
        public void onError(@NonNull Throwable e) {
            hideViewLoading();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            showViewRetry();
        }

        @Override
        public void onNext(@NonNull List<Product> products) {
            showProductsCollectionView(products);
        }
    }
}
