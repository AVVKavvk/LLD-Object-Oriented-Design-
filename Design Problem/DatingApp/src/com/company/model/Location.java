package com.company.model;

public class Location {
    private int xCordinet;
    private int yCordinet;

    public Location(int x,int y){
        this.xCordinet=x;
        this.yCordinet=y;
    }

    public void setxCordinet(int xCordinet) {
        this.xCordinet = xCordinet;
    }

    public void setyCordinet(int yCordinet) {
        this.yCordinet = yCordinet;
    }

    public int getxCordinet() {
        return xCordinet;
    }

    public int getyCordinet() {
        return yCordinet;
    }
}
