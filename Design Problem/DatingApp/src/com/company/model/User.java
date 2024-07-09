package com.company.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int userId;
    private String userName;
    private String userPhoneNumber;
    private Gender userGender;
    private Location userLocation;
    private int userAge;
    private Boolean isActiveUser;

    private Map<User,ActionType> userToActionTypeMap=new HashMap<>();
    private List<Match> userMatches=new ArrayList<>();
    private List<User> userWhoLikedYou=new ArrayList<>();

    public User(int userId, String userName, String userPhoneNumber, Gender userGender,
                Location userLocation, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userGender = userGender;
        this.userLocation = userLocation;
        this.userAge = userAge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Boolean getActiveUser() {
        return isActiveUser;
    }

    public void setActiveUser(Boolean activeUser) {
        isActiveUser = activeUser;
    }

    public Map<User, ActionType> getUserToActionTypeMap() {
        return userToActionTypeMap;
    }

    public void setUserToActionTypeMap(Map<User, ActionType> userToActionTypeMap) {
        this.userToActionTypeMap = userToActionTypeMap;
    }

    public List<Match> getUserMatches() {
        return userMatches;
    }

    public void setUserMatches(List<Match> userMatches) {
        this.userMatches = userMatches;
    }

    public List<User> getUserWhoLikedYou() {
        return userWhoLikedYou;
    }

    public void setUserWhoLikedYou(List<User> userWhoLikedYou) {
        this.userWhoLikedYou = userWhoLikedYou;
    }
}
