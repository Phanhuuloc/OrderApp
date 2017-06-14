package com.example.oa.orderapp.data.local;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.ResultRealmProxy;

/**
 * Created by Phoenix on 6/14/17.
 */
@Parcel(implementations = {ResultRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Result.class})
public class Result extends RealmObject{
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
