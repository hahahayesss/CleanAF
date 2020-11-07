package com.r00t.cleanaf.presentation.presenter;

import com.r00t.cleanaf.domain.exception.DefaultErrorBundle;
import com.r00t.cleanaf.domain.exception.ErrorBundle;
import com.r00t.cleanaf.domain.interactor.GetProductList;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.presentation.exception.ErrorMessageFactory;
import com.r00t.cleanaf.presentation.internal.di.DefaultObserver;
import com.r00t.cleanaf.presentation.view.ProductListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class ProductListPresenter implements Presenter {
    private GetProductList getProductListUseCase;

    private ProductListView view;

    @Inject
    public ProductListPresenter(GetProductList getProductListUseCase) {
        this.getProductListUseCase = getProductListUseCase;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        getProductListUseCase.dispose();
        view = null;
    }

    public void initialize() {
        loadProductList();
    }

    public void setView(ProductListView view) {
        this.view = view;
    }

    private void loadProductList() {
        hideViewRetry();
        hideViewContent();
        showViewLoading();
        getProductList();
    }

    private void showViewContent() {
        view.showContent();
    }

    private void hideViewContent() {
        view.hideContent();
    }

    private void showViewRetry() {
        view.showRetry();
    }

    private void hideViewRetry() {
        view.hideRetry();
    }

    private void showViewLoading() {
        view.showLoading();
    }

    private void hideViewLoading() {
        view.hideLoading();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    private void showProductListInView(List<Product> productList) {
        view.renderProductList(productList);
    }

    private void getProductList() {
        getProductListUseCase.execute(new ProductListObserver(), null);
    }

    private class ProductListObserver extends DefaultObserver<List<Product>> {

        @Override
        public void onComplete() {
            hideViewRetry();
            hideViewLoading();
            showViewContent();
        }

        @Override
        public void onError(@NonNull Throwable e) {
            hideViewLoading();
            hideViewContent();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            showViewRetry();
        }

        @Override
        public void onNext(@NonNull List<Product> products) {
            showProductListInView(products);
        }
    }
}
