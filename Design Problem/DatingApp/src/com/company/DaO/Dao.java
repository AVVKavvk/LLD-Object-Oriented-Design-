package com.company.DaO;

import com.company.Exceptions.CustomException;
import com.company.Utils.GetDistance;
import com.company.Utils.IdGenretor;
import com.company.model.*;

import java.util.*;

public class Dao {
    private static Dao daoInstance=null;
    private Dao(){

    };

    public static Dao getDaoInstance(){
        if(daoInstance==null){
            daoInstance=new Dao();
        }
        return daoInstance;
    }
    private int MAXDISTANCE=3;
    private Map<Integer,User> userIdToUserMap=new HashMap<>();
    private Map<String,Integer> userPhoneNUmberToUserIdMap=new HashMap<>();
    private Map<Integer, Match> matchIdToMatchMap=new HashMap<>();



    public User createUser(String userPhoneNumber, String userName, Gender userGender,
                           Location userLocation,int userAge) throws CustomException {

        try {
            if(userPhoneNUmberToUserIdMap.containsKey(userPhoneNumber)){
                new CustomException("User already Exits");
            }

            int userId=IdGenretor.getId();
            User user=new User(userId,userName,userPhoneNumber,userGender,userLocation,userAge);
            userIdToUserMap.put(userAge,user);
            userPhoneNUmberToUserIdMap.put(userPhoneNumber,userId);
            user.setActiveUser(true);

            return user;
        }
        catch (Exception e){
            throw e;
        }
    }
    public  Boolean deleteUser(User userToBeDeleted) throws CustomException {
        try {
            if(!userToBeDeleted.getActiveUser()){
                new CustomException("User Not Exits");
            }
            userToBeDeleted.setActiveUser(false);


            for(Match match :userToBeDeleted.getUserMatches()){
                if(match.getFirstUser().equals(userToBeDeleted) ||
                        match.getSecondUser().equals(userToBeDeleted)){
                    matchIdToMatchMap.remove(match.getMatchId());
                }
            }

            userToBeDeleted.getUserMatches().clear();


            for (User userWhoLikedMe:userToBeDeleted.getUserWhoLikedYou()){
                userWhoLikedMe.getUserToActionTypeMap().remove(userToBeDeleted);
            }

            for(Match match :matchIdToMatchMap.values()){
                if(match.getFirstUser().equals(userToBeDeleted)
                        || match.getSecondUser().equals(userToBeDeleted)){
                    matchIdToMatchMap.remove(match.getMatchId());
                }
            }
            return  true;

        }
        catch (Exception e){
            throw e;
        }
    }

    public List<User> findPotentialMatch(User userToFindMatch) throws CustomException {

        try {
            if(!userIdToUserMap.containsKey(userToFindMatch.getUserId())){
                throw new CustomException();
            }

            List<User> potentialUser=new ArrayList<>();

            for(User user:userIdToUserMap.values()){
                if(user.getActiveUser() &&
                        !user.getUserGender().equals(userToFindMatch.getUserGender())
                        &&
                        GetDistance.getDistance(user.getUserLocation(),userToFindMatch.getUserLocation())<MAXDISTANCE ){
                    potentialUser.add(user);
                }
            }

            if(potentialUser==null || potentialUser.size()==0){
                throw new CustomException();
            }

            Collections.sort(potentialUser,new sortByAge());

            System.out.println("Following are the potential matces");
            int count=0;
            for(User user:potentialUser){
                count++;
                System.out.println("User Name " + user.getUserName()+" user age "+ user.getUserAge());
            }
            return potentialUser;

        }
        catch (Exception e){
            throw e;
        }
    }

    public Match actOnPotentialMatches(int firstUserId, int secondUserId, ActionType actionType)
            throws CustomException {

        if(!userIdToUserMap.containsKey(firstUserId ) || ! userIdToUserMap.containsKey(secondUserId)){
            throw  new CustomException();
        }
        User firstUser=userIdToUserMap.get(firstUserId);
        User secondUser=userIdToUserMap.get(secondUserId);

        if(firstUser.getUserWhoLikedYou().contains(secondUser) && actionType==ActionType.Like){
            // it is a Match
            System.out.println("You found a match");
            Match match = new Match();
            int matchId=IdGenretor.getId();
            match.setMatchId(matchId);
            match.setFirstUser(firstUser);
            match.setSecondUser(secondUser);

            matchIdToMatchMap.put(matchId,match);
            return match;


        }
        firstUser.getUserToActionTypeMap().put(secondUser,actionType);
        if(actionType==ActionType.Like){
            secondUser.getUserWhoLikedYou().add(firstUser);
        }

        throw new CustomException("No Match found");
    }

    public  void getAllUserMatches(User user) throws Exception{
        if(!user.getActiveUser()){
            throw new CustomException();
        }
        if(user.getUserMatches().size()==0){
            throw new CustomException("No match exits ");
        }
        for(Match match : user.getUserMatches()){
            System.out.println(" User Name "+match.getSecondUser().getUserName() +" with user name "+match.getFirstUser().getUserName()   );

        }
    }
    public void getAllMatches() throws Exception{
        if(matchIdToMatchMap.size()==0){
            throw new CustomException("NO matches");
        }
        for(Match match : matchIdToMatchMap.values()){
            System.out.println(" User Name "+match.getSecondUser().getUserName() +" with user name "+match.getFirstUser().getUserName()   );

        }
    }

}

class sortByAge implements Comparator<User>{

    public int compare(User a,User b){
        return a.getUserAge()-b.getUserAge();
    }
}
