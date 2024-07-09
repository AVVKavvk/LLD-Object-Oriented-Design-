package com.company.Service;

import com.company.DaO.Dao;
import com.company.Exceptions.CustomException;
import com.company.model.*;

public class UserService {
    private static UserService userServiceInstance=null;
    private UserService(){

    };

    public static UserService getUserServiceInstance(){
        if(userServiceInstance==null){
            userServiceInstance=new UserService();
        }
        return userServiceInstance;
    }
    Dao dao=Dao.getDaoInstance();
    public User createUser(String userPhoneNumber, String userName, Gender userGender, Location userLocation,int userAge) throws  Exception{

        if(userPhoneNumber==null || userPhoneNumber.isEmpty() || userName.isEmpty() || userAge<=0 ){
            throw  new CustomException("Invaild Details");
        }

        return dao.createUser(userPhoneNumber,userName,userGender,userLocation,userAge);
    }
    public  boolean deleteUser(User userToBeDeleted) throws Exception{
        return dao.deleteUser(userToBeDeleted);
    }
    public Match actOnPotentialMatches(int firstUserId, int secondUserId, ActionType actionType)
            throws CustomException{
        return dao.actOnPotentialMatches(firstUserId,secondUserId,actionType);
    }

}
