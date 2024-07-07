package com.company.Builder;

import com.company.Product.House;

public interface Builder {

    public void buildBasement ();
    public void buildStructure();
    public void buildRoof();
    public void buildInterior();
    public House getHouse();
}
