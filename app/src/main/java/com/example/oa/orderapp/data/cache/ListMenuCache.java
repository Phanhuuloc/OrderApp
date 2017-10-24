package com.example.oa.orderapp.data.cache;

import com.example.oa.orderapp.data.local.Mon;
import com.example.oa.orderapp.data.local.RealmListParcelConverter;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import io.realm.ListMenuCacheRealmProxy;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 6/14/17.
 */

@Parcel(implementations = {ListMenuCacheRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {ListMenuCache.class})
public class ListMenuCache extends RealmObject{
    private RealmList<Mon> items;
    private int count;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<Mon> getItems() {
        return items;
    }

    public void setItems(RealmList<Mon> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


