package com.example.oa.orderapp.data.local;

import com.example.oa.orderapp.data.ODObject;

import org.parceler.Parcel;

import java.util.UUID;

import io.realm.ProviderRealmProxy;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by Phoenix on 6/14/17.
 */
@Parcel(implementations = {ProviderRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Provider.class})
public class Provider extends RealmObject implements ODObject {
    private String uuid;
    private String name;
    private String image;
    private String description;
    private String address;
    private String url;
    private String openHour;
    private String star;

    public Provider() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}

