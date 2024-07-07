package com.company.Phones;

public class Redmi implements Phone{

    @Override
    public void getModel() {
        System.out.println("Poco X6");
    }

    @Override
    public void getRupee() {
        System.out.println("25000");
    }
}
