package com.example.oa.orderapp.data.cache;

import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.data.local.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import io.realm.ListProviderCacheRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 6/27/17.
 */
@Parcel(implementations = {ListProviderCacheRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {ListProviderCache.class})
public class ListProviderCache extends RealmObject {
    private RealmList<Provider> items;
    private int count;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<Provider> getItems() {
        return items;
    }

    public void setItems(RealmList<Provider> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
