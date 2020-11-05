package com.r00t.cleanaf.presentation.internal.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.r00t.cleanaf.data.net.abstaction.NetService;
import com.r00t.cleanaf.data.net.implementation.NetServiceImpl;
import com.r00t.cleanaf.data.net.mappers.NetMapper;
import com.r00t.cleanaf.data.net.retrofit.RemoteService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.spermatorial.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    @Singleton
    @Provides
    public RemoteService provideRemoteService(Retrofit.Builder builder) {
        return builder.build().create(RemoteService.class);
    }

    @Singleton
    @Provides
    public NetService provideNetService(@ApplicationContext Context context, RemoteService remoteService, NetMapper netMapper) {
        return new NetServiceImpl(remoteService, netMapper, context);
    }
}
