package com.r00t.cleanaf.data.net.retrofit;

import com.r00t.cleanaf.data.net.model.ProductNetEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RemoteService {

    @GET("/product")
    Observable<List<ProductNetEntity>> getNetProducts();
}
