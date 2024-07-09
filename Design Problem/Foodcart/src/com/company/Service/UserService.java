package com.company.Service;

import com.company.DAO.UserDao;
import com.company.constant.Gender;
import com.company.model.User;

public class UserService {
    private static UserService userInstance=null;
    private UserService(){

    };

    public static UserService getUserInstance(){
        if(userInstance==null){
            userInstance=new UserService();
        }
        return userInstance;
    }

    UserDao userDao=UserDao.getInstance();

    public User userRegister(Long phone, String name, Long pincode, Gender gender){
        if(phone==null || phone<=0){
            System.out.println("Phone number not vaild");
            return null;

        }
        if(pincode==null || pincode<=0){
            System.out.println("Pincode not vaild");
            return  null;
        }
        if(name.isEmpty()){
            System.out.println("Name is not vaild");
            return  null;
        }
        return userDao.registerUser(phone,name,pincode,gender);
    }

    public User login(Long phone){
        if(phone==null || phone<=0){
            System.out.println("Phone number not vaild");
            return null;
        }
        return userDao.login(phone);
    }
}
