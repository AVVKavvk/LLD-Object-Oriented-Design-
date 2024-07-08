package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String Item;
    private int price;
    private int quantity;
    private Float rating;
    private List<Long> servicablePincodes;
    private List<Review> reviews=new ArrayList<>();

    public void setItem(String item) {
        Item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return Item;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public List<Long> getServicablePincodes() {
        return servicablePincodes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(Float reating) {
        this.rating = reating;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setServicablePincodes(List<Long> servicablePincodes) {
        this.servicablePincodes = servicablePincodes;
    }

}
