package com.company.model;

public class Order {
    private int id;
    private int userId;
    private int restaurantId;
    private int quantity;
    private Long cost;
    private String item;

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public Long getCost() {
        return cost;
    }

    public String getItem() {
        return item;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
