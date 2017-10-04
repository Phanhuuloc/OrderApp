package com.example.oa.orderapp.data.local;

import com.example.oa.orderapp.data.ODObject;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.realm.ValueRealmProxy;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Phoenix on 6/14/17.
 */
@Parcel(implementations = {ValueRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Value.class})
public class Value extends RealmObject implements ODObject {
    @Ignore
//    private String uuid;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("description")
    private String description;
    @SerializedName("note")
    private String note;

    public Value() {
    }

    public Value(String name) {
        this.name = name;
    }

//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
