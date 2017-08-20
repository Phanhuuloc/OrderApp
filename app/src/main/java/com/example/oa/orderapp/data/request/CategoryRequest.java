package com.example.oa.orderapp.data.request;

/**
 * Created by Phoenix on 8/20/17.
 * {
 * "name" : "Tra sua",
 * "defaultImage": "tt.jpg",
 * "provider":{
 * "uuid": "6c3e8069-f81e-4d19-ad59-c0338c2b926b"
 * }
 * }
 */

public class CategoryRequest {
    String name;
    String defaultImage;
    String description;
    ObjRequest provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
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
}
