package com.company.service;

import com.company.dao.cacheModel;

public class cacheService {

    private static cacheService instance =null;

    private cacheService(){};
    private cacheModel cachemodel= cacheModel.getCacheModelInstance();
    public  static synchronized cacheService getInstance(){
        if(instance==null){
            instance= new cacheService();
        }
        return instance;
    }

    public void init(int size,String policy){
            cachemodel.createCache(size,policy);
    }
    public Object get(int key){
        return cachemodel.get(key);
    }
    public Boolean put(int key,Object obj){
        return cachemodel.put(key,obj);
    }
    public Boolean delete(int key){
        return cachemodel.delete(key);
    }
    public Boolean clear(){
        return cachemodel.clear();
    }

}
