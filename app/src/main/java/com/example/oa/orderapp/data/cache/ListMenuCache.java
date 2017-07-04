package com.example.oa.orderapp.data.cache;

import com.example.oa.orderapp.data.local.Menu;
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
    private RealmList<Menu> items;
    private int count;

    @ParcelPropertyConverter(RealmListParcelConverter.class)
    public RealmList<Menu> getItems() {
        return items;
    }

    public void setItems(RealmList<Menu> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


