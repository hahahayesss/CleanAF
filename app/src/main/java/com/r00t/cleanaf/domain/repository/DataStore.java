package com.r00t.cleanaf.domain.repository;

import com.r00t.cleanaf.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public interface DataStore {

    Observable<List<Product>> getAllProducts();
}
