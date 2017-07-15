package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RetrofitServices {
    @GET("provider/list")
    Observable<ListProviderCache> getListProvider();

    @GET("provider/menu/{name}")
    Observable<ListMenuCache> getListMenu(@Path("name") String name);

    @GET("provider/{name}")
    Observable<Provider> getProvider(@Path("name") String uid);

    @GET("category/menu/{name}")
    Observable<ListCategoryCache> getListCategory(@Path("name") String uid);
}
