package com.company.Builder;

import com.company.Product.House;

public class TreeHouseBuilder implements Builder {
    public House house;
    public TreeHouseBuilder(){
        this.house= new House();
    }

    @Override
    public void buildBasement() {
        house.setBasement("set Basement by Tree Builder");
    }

    @Override
    public void buildStructure() {
        house.setStructure("set Structure by Tree Builder ");
    }

    @Override
    public void buildRoof() {
        house.setRoof("set Roof by Tree Builder");
    }

    @Override
    public void buildInterior() {
        house.setInterior("set Interior by Tree Builder ");
    }
    @Override
    public House getHouse(){
        return house;
    }
}
