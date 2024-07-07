package com.company.Product;

public class House {

    private  String basement;
    private  String structure;
    private  String roof;
    private String interior;

    public void setBasement(String basement) {
        this.basement=basement;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }


    public String getBasement(){
        return this.basement;
    }

    public String getInterior() {
        return interior;
    }

    public String getStructure() {
        return structure;
    }

    public String getRoof() {
        return roof;
    }
}
