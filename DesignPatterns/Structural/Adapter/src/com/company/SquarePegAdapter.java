package com.company;

public class SquarePegAdapter extends RoundPeg
{
    private  SquarePeg squarePeg;

    SquarePegAdapter( SquarePeg s){
        this.squarePeg=s;
    }
    @Override
    public double getRadius(){
        return squarePeg.getWidth()*(Math.sqrt(2))/2;
    }
}
