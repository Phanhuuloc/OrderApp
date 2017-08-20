package com.example.oa.orderapp.data.request;

import com.example.oa.orderapp.data.local.Value;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by Phoenix on 8/20/17.
 * {
 * "type" : "1",
 * "price": "20000",
 * "user":{
 * "uuid": "f21b20cf-4335-4eed-ac72-14596b8b4394"
 * },
 * "listItem":[
 * {
 * "uuid": "027548a9-df8b-4835-a662-fe9cb3fb6056"
 * <p>
 * },
 * {
 * "uuid": "ad1ecaf6-117d-4bfd-9540-49c547bc9777"
 * <p>
 * }
 * ]
 * <p>
 * }
 */
public class BillRequest {
    String type;
    String price;
    ObjRequest user;
    List<Value> listItem;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ObjRequest getUser() {
        return user;
    }

    public void setUser(ObjRequest user) {
        this.user = user;
    }

    public List<Value> getListItem() {
        return listItem;
    }

    public void setListItem(List<Value> listItem) {
        this.listItem = listItem;
    }

    public static BillRequest from(RealmList purchaseList) {
        BillRequest billRequest = new BillRequest();
        billRequest.setType("1");
        billRequest.setPrice("200000");
        billRequest.setUser(new ObjRequest("f21b20cf-4335-4eed-ac72-14596b8b4394"));
        billRequest.setListItem(purchaseList);
        return billRequest;
    }
}
