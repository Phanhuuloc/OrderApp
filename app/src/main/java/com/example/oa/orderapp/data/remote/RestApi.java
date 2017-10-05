package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.data.request.BillRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RestApi {

    @GET("provider/list")
    Observable<ListProviderCache> getListProvider();

    @GET("provider/{id}/menu")
    Observable<ListMenuCache> getListMenu(@Path("id") String name);

    @GET("provider/{name}")
    Observable<Provider> getProvider(@Path("name") String uid);

    @GET("provider/{id}/category")
    Observable<ListCategoryCache> getListCategory(@Path("id") String uid);

    @Headers({"Content-Type: application/json;charset=UTF-8",
            "Accept:application/json",
            "Accept-Encoding:gzip, deflate",
            "Accept-Language:en"})
    @POST("bill")
    Observable<ListCategoryCache> sendBillReq(@Body BillRequest req);

    //    @Multipart
    @Headers({"Content-Type: application/json;charset=UTF-8",
            "Accept:application/json, text/javascript, */*; q=0.01",
            "Accept-Encoding:gzip, deflate",
            "Accept-Language:en"})
    @FormUrlEncoded
    @POST("bill")
    Observable<ListCategoryCache> sendBillReq(@Field("price") long data);
}

