package com.r00t.cleanaf.data.repository;

import com.r00t.cleanaf.data.cache.abstraction.CacheService;
import com.r00t.cleanaf.data.net.abstaction.NetService;
import com.r00t.cleanaf.domain.model.Product;
import com.r00t.cleanaf.domain.repository.DataStore;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataStoreImpl implements DataStore {
    private static final long CACHE_TIME_OUT = 5000;
    private static long LAST_UPDATE_TIMESTAMP = 0;

    private CacheService cacheService;
    private NetService netService;

    @Inject
    public DataStoreImpl(CacheService cacheService, NetService netService) {
        this.cacheService = cacheService;
        this.netService = netService;
    }

    @Override
    public Observable<List<Product>> getAllProducts() {
        if (shouldRequestFromRemote()) {
            return netService.getProducts()
                    .doOnNext(pList -> cacheService.insertProducts(pList));
        } else {
            return cacheService.getAllProducts();
        }
    }

    private static boolean shouldRequestFromRemote() {
        long currentTimestamp = System.currentTimeMillis();
        if (CACHE_TIME_OUT > currentTimestamp - LAST_UPDATE_TIMESTAMP)
            return false;
        LAST_UPDATE_TIMESTAMP = currentTimestamp;
        return true;
    }
}
