package com.company;

import com.company.Builder.Builder;
import com.company.Builder.IglooHouseBulilder;
import com.company.Builder.TreeHouseBuilder;
import com.company.Director.CivilEngineer;
import com.company.Product.House;

public class Main {
    public static void main(String[] args) {

//        Builder iglooBuilder= new IglooHouseBulilder();

          Builder treeHouse= new TreeHouseBuilder();
          CivilEngineer engineer= new CivilEngineer(treeHouse);

        engineer.constructHouse();

        House house = engineer.gethouse();

        System.out.println(house);
        System.out.println(house.getBasement());
        System.out.println(house.getStructure());
        System.out.println(house.getRoof());
        System.out.println(house.getInterior());
    }
}
