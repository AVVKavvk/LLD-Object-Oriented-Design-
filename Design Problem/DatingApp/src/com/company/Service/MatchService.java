package com.company.Service;

import com.company.DaO.Dao;
import com.company.Exceptions.CustomException;
import com.company.model.User;

import java.util.List;

public class MatchService {
    private static MatchService matchServiceInstance=null;

    private MatchService(){

    };

    public static MatchService getMatchServiceInstance(){
        if(matchServiceInstance==null){
            matchServiceInstance=new MatchService();
        }
        return matchServiceInstance;
    }

    Dao dao= Dao.getDaoInstance();

    public List<User> findPotentialMatch(User userToFindMatch) throws CustomException{
        return dao.findPotentialMatch(userToFindMatch);
    }
    public  void getAllUserMatches(User user) throws Exception{
        dao.getAllUserMatches(user);

    }
    public void getAllMatches() throws Exception{
        dao.getAllMatches();
    }

}
