package com.company.Service;

import com.company.DAO.UserDao;
import com.company.model.Restaurant;
import com.company.model.Review;

import java.util.List;

public class RestarantService {
    private static RestarantService resInstance=null;

    private RestarantService(){

    };

    public static RestarantService getResInstance(){
        if(resInstance==null){
            resInstance=new RestarantService();
        }
        return resInstance;
    }

    private UserDao userDao= UserDao.getInstance();
    public Restaurant registerRestauerant(String resName,String pincodes,String Item,int price,int quantity){

        if(resName.isEmpty()){
            System.out.println("Restaurant name not vaild");
            return null;
        }
        if(price<=0 || quantity<=0){
            System.out.println("Not vaild price or qunatity");
            return  null;
        }

        return  userDao.registerRestauerant(resName,pincodes,Item,price,quantity);
    }

    public Review rateRestaurent(String resName,int socre,String comment){

        if(comment.isEmpty() || socre<=0 || socre>5){
            System.out.println("Invaild ratings");
            return null;
        }

        return userDao.rateRestaurent(resName,socre,comment);
    }
    public Restaurant updateQuntity(String resName,int quantity){
        if(quantity<=0){
            System.out.println("Ïnvaild Quanity ");
            return  null;
        }
        return userDao.updateQuntity(resName,quantity);
    }
    public List<Restaurant> showRestaurents(String sortBy){
        if (sortBy.isEmpty()){
            System.out.println("Invaild string Type");
            return null;
        }

        return userDao.showRestaurents(sortBy);
    }
}
