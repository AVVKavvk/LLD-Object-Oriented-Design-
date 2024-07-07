package com.company.Phones;

public class IPhone implements  Phone{

    @Override
    public void getModel() {
        System.out.println("Iphone 15");

    }

    @Override
    public void getRupee() {
        System.out.println("145000");
    }
}
