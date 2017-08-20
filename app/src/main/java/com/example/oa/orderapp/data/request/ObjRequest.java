package com.example.oa.orderapp.data.request;

/**
 * Created by Phoenix on 8/20/17.
 */

public class ObjRequest{
    String uuid;

    public ObjRequest() {
    }

    public ObjRequest(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
