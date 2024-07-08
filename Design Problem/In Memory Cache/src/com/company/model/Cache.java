package com.company.model;

public class Cache {
    private int size;
    private String Policy;

    public Cache(int size, String policy){
        this.size=size;
        this.Policy=policy;
    }
    public int getSize(){
        return this.size;
    }
    public String getPolicy(){
        return this.Policy;
    }

}
