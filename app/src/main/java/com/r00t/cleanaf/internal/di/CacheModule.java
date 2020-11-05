package com.r00t.cleanaf.internal.di;

import android.content.Context;

import androidx.room.Room;

import com.r00t.cleanaf.data.cache.abstraction.CacheService;
import com.r00t.cleanaf.data.cache.database.CacheDatabase;
import com.r00t.cleanaf.data.cache.database.ProductDao;
import com.r00t.cleanaf.data.cache.implementation.CacheServiceImpl;
import com.r00t.cleanaf.data.cache.mappers.CacheMapper;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class CacheModule {

    @Provides
    public CacheDatabase provideCacheDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, CacheDatabase.class, CacheDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    public ProductDao provideProductDao(CacheDatabase cacheDatabase) {
        return cacheDatabase.getProductDao();
    }

    @Provides
    public CacheService provideCacheService(ProductDao productDao, CacheMapper cacheMapper) {
        return new CacheServiceImpl(productDao, cacheMapper);
    }
}
