package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/14/17.
 */
@Singleton
public class RestApiImpl implements RestApi {
    private final RetrofitServices r;
    private final EntityJsonMapper jsonMapper;
//    private final ApiConnection apiConnection;

    @Inject
    public RestApiImpl(RetrofitServices retrofitServices, EntityJsonMapper jsonMapper/*, ApiConnection apiConnection*/) {
        this.r = retrofitServices;
        this.jsonMapper = jsonMapper;
//        this.apiConnection = apiConnection;
    }

    @Override
    public Observable<ListProviderCache> getListProvider() {
        return this.r.getListProvider();
    }

    @Override
    public Observable<ListMenuCache> getListMenu(String name) {
        return this.r.getListMenu(name);
    }

    @Override
    public Observable<Provider> getProvider(String uid) {
        return this.r.getProvider(uid);
    }

    @Override
    public Observable<ListCategoryCache> getListCategory(String uid) {
        return this.r.getListCategory(uid);
    }
}
