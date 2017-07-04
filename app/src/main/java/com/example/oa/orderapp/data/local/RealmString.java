package com.example.oa.orderapp.data.local;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.RealmStringRealmProxy;

/**
 * Created by Phoenix on 6/28/17.
 */

@Parcel(implementations = {RealmStringRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {RealmString.class})
public class RealmString extends RealmObject {
    public String value;

    public RealmString() {
    }

    protected RealmString(android.os.Parcel in) {
        this.value = in.readString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}

