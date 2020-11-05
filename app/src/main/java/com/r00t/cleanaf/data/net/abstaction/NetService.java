package com.r00t.cleanaf.data.net.abstaction;

import com.r00t.cleanaf.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public interface NetService {

    Observable<List<Product>> getProducts();
}
