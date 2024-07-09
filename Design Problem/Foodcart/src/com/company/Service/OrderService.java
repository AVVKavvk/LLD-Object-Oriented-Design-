package com.company.Service;

import com.company.DAO.UserDao;
import com.company.model.Order;

import java.util.List;

public class OrderService {
    private static OrderService orderInstance=null;
    private OrderService(){

    };

    public static OrderService getOrderInstance(){
        if(orderInstance==null){
            orderInstance=new OrderService();
        }
        return orderInstance;
    }

    UserDao userDao= UserDao.getInstance();

    public Order placeOrder(String resName,int qunatity){

        if(resName.isEmpty()){
            System.out.println("Invaild Restaurant name");
            return null;
        }
        if(qunatity<=0){
            System.out.println("add some item");
            return null;
        }

        return userDao.placeOrder(resName,qunatity);
    }
    public List<Order> allOrder(){


        return userDao.orderList();
    }
}
