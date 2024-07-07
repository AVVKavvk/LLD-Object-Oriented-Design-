package com.company;

public class RoundHole {
    private  double radius;

    public RoundHole(double radius){
        this.radius=radius;
    }

    public double getRadius(){
        return this.radius;
    }
    public  boolean isFits(RoundPeg p){
        return this.radius>=p.getRadius();
    }
}
