package com.r00t.cleanaf.data.cache.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.r00t.cleanaf.data.cache.model.ProductCacheEntity;

@Database(entities = ProductCacheEntity.class, version = 1)
public abstract class CacheDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "cache_db";

    public abstract ProductDao getProductDao();
}
