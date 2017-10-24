package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.data.request.BillRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RestApi {

    @GET("provider/list")
    Observable<ListProviderCache> getListProvider();

    @GET("item/c")
    Observable<ListMenuCache> getListMon(@Query("cid") String cid);

    @GET("provider/{name}")
    Observable<Provider> getProvider(@Path("name") String uid);

    @GET("category/p")
    Observable<ListCategoryCache> getListCategory(@Query("pid") String pid);

    @Headers({"Content-Type: application/json;charset=UTF-8",
            "Accept:application/json",
            "Accept-Encoding:gzip, deflate",
            "Accept-Language:en"})
    @POST("bill")
    Observable<ListCategoryCache> sendBillReq(@Body BillRequest req, @Query("pid") String pid);

}

