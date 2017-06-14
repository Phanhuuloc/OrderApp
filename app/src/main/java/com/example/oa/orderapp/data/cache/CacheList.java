package com.example.oa.orderapp.data.cache;

import com.example.oa.orderapp.data.ODObject;

import org.parceler.Parcel;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Phoenix on 6/14/17.
 */

@Parcel
public class CacheList<T extends ODObject> extends RealmObject{
//    private List<T> items;
    public int count;
}


