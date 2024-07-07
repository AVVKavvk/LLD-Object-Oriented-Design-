package com.company.Phones;

public class Samsung implements Phone{

    @Override
    public void getModel() {
        System.out.println("Samsung S24 ultra");
    }

    @Override
    public void getRupee() {
        System.out.println("100200");
    }
}
