package com.example.oa.orderapp.data.request;

/**
 * Created by Phoenix on 8/20/17.
 * {
 * "name" : " High Land",
 * "image": "provider.jpg",
 * "description":"ca phe HL",
 * "address": "D2 street",
 * "url": "hh.com",
 * "latitude": "300",
 * "longitude": "900",
 * "openHour": "8:10",
 * "star":"5"
 * }
 */

public class ProviderRequest {
    String name;
    String image;
    String description;
    String address;
    String url;
    String longitude;
    String latitude;
    String star;

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
