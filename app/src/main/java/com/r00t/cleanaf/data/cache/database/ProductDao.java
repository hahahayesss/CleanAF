package com.r00t.cleanaf.data.cache.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.r00t.cleanaf.data.cache.model.ProductCacheEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertCache(ProductCacheEntity cacheEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertCaches(List<ProductCacheEntity> cacheEntities);

    @Query("SELECT * FROM products")
    Flowable<List<ProductCacheEntity>> getAllCaches();
}
