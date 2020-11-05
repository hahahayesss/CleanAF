package com.r00t.cleanaf.domain.interactor;

import com.r00t.cleanaf.domain.executor.PostExecutionThread;
import com.r00t.cleanaf.domain.executor.ThreadExecutor;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.domain.repository.DataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetProductList extends UseCase<List<Product>, Void> {
    private DataStore dataStore;

    @Inject
    public GetProductList(DataStore dataStore, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.dataStore = dataStore;
    }

    @Override
    Observable<List<Product>> buildUseCaseObservable(Void aVoid) {
        return dataStore.getAllProducts();
    }
}
