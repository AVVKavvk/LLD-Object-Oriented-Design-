package com.company.Builder;

import com.company.Product.House;

public class IglooHouseBulilder implements Builder {

    public House house;
     public IglooHouseBulilder(){
         this.house= new House();
     }

    @Override
    public void buildBasement() {
        house.setBasement("set Basement by Igloo Builder");
    }

    @Override
    public void buildStructure() {
        house.setStructure("set Structure by Igloo Builder ");
    }

    @Override
    public void buildRoof() {
        house.setRoof("set Roof by Igloo Builder");
    }

    @Override
    public void buildInterior() {
        house.setInterior("set Interior by Igloo Builder ");
    }
    @Override
    public House getHouse(){
         return house;
    }
}
