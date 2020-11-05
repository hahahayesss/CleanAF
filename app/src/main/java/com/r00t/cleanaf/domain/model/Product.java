package com.r00t.cleanaf.domain.model;

public class Product {
    private String id;
    private String name;
    private String discount;
    private String language;
    private int kitSize;
    private double price;
    private long creationDate;
    private long updatedDate;

    public Product() {
    }

    public Product(String id, String name, String discount, String language, int kitSize, double price, long creationDate, long updatedDate) {
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
