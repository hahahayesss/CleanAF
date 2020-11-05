package com.r00t.cleanaf.data.cache.abstraction;

import com.r00t.cleanaf.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public interface CacheService {

    Observable<?> insertProduct(Product product);

    Observable<?> insertProducts(List<Product> products);

    Observable<List<Product>> getAllProducts();
}
