package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/14/17.
 */

public interface RestApi {

    Observable<ListProviderCache> getListProvider();

    Observable<ListMenuCache> getListMenu(String name);

    Observable<Provider> getProvider(String uid);
}
