package com.company.Director;

import com.company.Builder.Builder;
import com.company.Product.House;

public class CivilEngineer {
    public Builder builder;

    public CivilEngineer( Builder builder){
        this.builder=builder;
    }

    public  void constructHouse(){
        this.builder.buildBasement();
        this.builder.buildStructure();
        this.builder.buildRoof();
        this.builder.buildInterior();
    }
     public House gethouse(){
        return builder.getHouse();
     }
}
