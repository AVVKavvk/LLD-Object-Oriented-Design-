package com.company.model;

import com.company.constant.Gender;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private Gender gender;
    private Long phone;
    private Long pincode;
    private List<Restaurant> restaurants=new ArrayList<>();
    private List<Order>orders=new ArrayList<>();

    public User(int id,String name,Gender gender,Long phone,Long pincode){
        this.gender=gender;
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.pincode=pincode;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Long getPhone() {
        return phone;
    }

    public Long getPincode() {
        return pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
