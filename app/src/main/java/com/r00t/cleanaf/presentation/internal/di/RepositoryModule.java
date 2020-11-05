package com.r00t.cleanaf.presentation.internal.di;

import com.r00t.cleanaf.data.cache.abstraction.CacheService;
import com.r00t.cleanaf.data.net.abstaction.NetService;
import com.r00t.cleanaf.data.repository.DataStoreImpl;
import com.r00t.cleanaf.domain.repository.DataStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class RepositoryModule {

    @Singleton
    @Provides
    public DataStore provideDataStore(CacheService cacheService, NetService netService) {
        return new DataStoreImpl(cacheService, netService);
    }
}
