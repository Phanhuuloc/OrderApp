package com.example.oa.orderapp.data.request;

import io.realm.RealmObject;

/**
 * Created by Phoenix on 8/20/17.
 * {
 * "name" : " ca phe sua 3",
 * "price": "2000",
 * "description":"ca phe sua 3",
 * "provider":{
 * "uuid": "6c3e8069-f81e-4d19-ad59-c0338c2b926b"
 * },
 * "category":{
 * "uuid": "cd1d7545-587a-4f77-a356-5e798a99537f"
 * }
 * }
 */

public class ItemRequest {
    String name;
    String price;
    String description;
    ObjRequest provider;
    ObjRequest category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjRequest getProvider() {
        return provider;
    }

    public void setProvider(ObjRequest provider) {
        this.provider = provider;
    }

    public ObjRequest getCategory() {
        return category;
    }

    public void setCategory(ObjRequest category) {
        this.category = category;
    }
}
