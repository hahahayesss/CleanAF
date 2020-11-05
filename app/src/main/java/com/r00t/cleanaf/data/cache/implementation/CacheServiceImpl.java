package com.r00t.cleanaf.data.cache.implementation;

import com.r00t.cleanaf.data.cache.abstraction.CacheService;
import com.r00t.cleanaf.data.cache.database.ProductDao;
import com.r00t.cleanaf.data.cache.mappers.CacheMapper;
import com.r00t.cleanaf.domain.model.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CacheServiceImpl implements CacheService {
    private ProductDao productDao;
    private CacheMapper cacheMapper;

    @Inject
    public CacheServiceImpl(ProductDao productDao, CacheMapper cacheMapper) {
        this.productDao = productDao;
        this.cacheMapper = cacheMapper;
    }

    @Override
    public Observable<?> insertProduct(Product product) {
        return productDao.insertCache(cacheMapper.mapToEntity(product))
                .toObservable();
    }

    @Override
    public Observable<?> insertProducts(List<Product> products) {
        return productDao.insertCaches(cacheMapper.mapToEntities(products))
                .toObservable();
    }

    @Override
    public Observable<List<Product>> getAllProducts() {
        return productDao.getAllCaches()
                .map(pList -> cacheMapper.mapFromEntities(pList))
                .toObservable();
    }
}
