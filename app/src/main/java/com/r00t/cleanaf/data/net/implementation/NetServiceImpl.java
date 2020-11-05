package com.r00t.cleanaf.data.net.implementation;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.r00t.cleanaf.data.net.retrofit.RemoteService;
import com.r00t.cleanaf.data.exception.NetworkConnectionException;
import com.r00t.cleanaf.data.net.abstaction.NetService;
import com.r00t.cleanaf.data.net.mappers.NetMapper;
import com.r00t.cleanaf.domain.model.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class NetServiceImpl implements NetService {
    private RemoteService remoteService;
    private NetMapper netMapper;
    private Context context;

    @Inject
    public NetServiceImpl(RemoteService remoteService, NetMapper netMapper, Context context) {
        this.remoteService = remoteService;
        this.netMapper = netMapper;
        this.context = context;
    }

    @Override
    public Observable<List<Product>> getProducts() {
        return remoteService.getNetProducts()
                .flatMap(pList -> {
                    if (isThereInternetConnection())
                        return Observable.just(netMapper.mapFromEntities(pList));
                    else
                        return Observable.create(emitter -> emitter.onError(new NetworkConnectionException()));
                });
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }
}
