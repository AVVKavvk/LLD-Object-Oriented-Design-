package com.company.dao;

import com.company.model.Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class cacheModel {
    private static cacheModel cacheModelInstance=null;
    private Cache cache=null;
    private LinkedList<Object> dataStore;
    private Map<Object,Object> dataCache;

    private cacheModel(){
    }
    public static synchronized cacheModel getCacheModelInstance(){
        if(cacheModelInstance==null){
            cacheModelInstance= new cacheModel();

        }
        return cacheModelInstance;
    }
    public void createCache(int size,String policy){
        cache=new Cache(size,policy);
        dataCache= new HashMap<>();
        dataStore= new LinkedList<>();
    }

    public Object get(int key){
        Object result= this.dataCache.get(key);

        if(result==null) return null;

        this.dataStore.remove(result);
        this.dataStore.addFirst(result);
        return result;
    }

    public Boolean put(int key,Object val){
        try {
            if(cache.getSize()==this.dataStore.size()){
                Object last=this.dataStore.removeLast();
                this.dataCache.remove(last);
            }
            this.dataCache.remove(key);
            this.dataStore.addFirst(val);
            this.dataCache.put(key,val);
            return true;

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(int key){
        if(this.dataCache.size()==0) return true;

        try {
            Object obj=this.dataCache.get(key);
            this.dataCache.remove(key);
            this.dataStore.remove(obj);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Boolean clear(){
        try {
            this.dataCache.clear();
            this.dataStore.clear();
            return true;
        }
        catch ( Exception e){
            e.printStackTrace();
            return false;
        }
    }
//    public
//
}
