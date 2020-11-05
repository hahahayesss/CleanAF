package com.r00t.cleanaf.data.net.model;

import com.google.gson.annotations.SerializedName;

public class ProductNetEntity {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("discountCode")
    private String discount;

    @SerializedName("languageTag")
    private String language;

    @SerializedName("kitSize")
    private int kitSize;

    @SerializedName("price")
    private double price;

    @SerializedName("creationDate")
    private long creationDate;

    @SerializedName("updatedDate")
    private long updatedDate;

    public ProductNetEntity() {
    }

    public ProductNetEntity(String id, String name, String discount, String language, int kitSize, double price, long creationDate, long updatedDate) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.language = language;
        this.kitSize = kitSize;
        this.price = price;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getKitSize() {
        return kitSize;
    }

    public void setKitSize(int kitSize) {
        this.kitSize = kitSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }
}

/*
        "id": "5f01bfb3ad43c275a0fe6040",
        "name": "Standard",
        "discountCode": null,
        "languageTag": "en",
        "kitSize": 1,
        "price": 400.0,
        "creationDate": 1593950131133,
        "updatedDate": 1598539946284
 */