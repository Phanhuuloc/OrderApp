package com.example.oa.orderapp.data.request;

import com.example.oa.orderapp.data.local.Mon;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("price")
    @Expose
    private long price;
    @SerializedName("mons")
    @Expose
    private List<Mon> mons;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Mon> getMons() {
        return mons;
    }

    public void setMons(List<Mon> mons) {
        this.mons = mons;
    }


    public static BillRequest from(List<Mon> purchaseList) {
        BillRequest billRequest = new BillRequest();
        billRequest.setType("1");
        billRequest.setPrice(200000);
//        billRequest.setUser(new ObjRequest("f21b20cf-4335-4eed-ac72-14596b8b4394"));
        billRequest.setMons(purchaseList);
        return billRequest;
    }
}
