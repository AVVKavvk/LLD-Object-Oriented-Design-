package com.company.DAO;

import com.company.Utils.IdGenretor;
import com.company.constant.Gender;
import com.company.model.Restaurant;
import com.company.model.Review;
import com.company.model.User;

import java.util.*;

public class UserDao {
    private static UserDao userdao=null;

    private UserDao(){

    };
    public UserDao getInstance(){
        if(userdao==null) {
            userdao=new UserDao();
        }
        return userdao;
    }

    private HashMap<Integer, User> idToUserMap=new HashMap<>();
    private HashMap<Long,Integer> phoneToIdMap=new HashMap<>();
    private HashMap<String, Restaurant> nameToRestaurantMap=new HashMap<>();

    private User loggedInUser=null;

    public User registerUser(Long phone, String name, Long pincode, Gender gender){
        if(phoneToIdMap.containsKey(phone)){
            User user=idToUserMap.get(phoneToIdMap.get(phone));
            System.out.println("User Alredy Extis with userId "+user.getId()+" and phone number "+user.getPhone());
            return user;
        }
        User user=new User(IdGenretor.getId(),name,gender,phone,pincode);
        idToUserMap.put(user.getId(),user);
        phoneToIdMap.put(phone,user.getId());
        System.out.println("User Created successfully with id " +user.getId());
        return user;
    }

    public User login(Long phone){
        if(!phoneToIdMap.containsKey(phone)){
            System.out.println("User not exits with this phone number "+phone);
                                                                             // TODO: add Exception here
            return null;
        }
        User user=idToUserMap.get(phoneToIdMap.get(phone));
        loggedInUser=user;
        System.out.println("Successfully loggedIn with user id" + user.getId());
        return user;
    }

    public Restaurant registerRestauerant(String name,String pincodes,String Item,int price,int quantity){
        if(loggedInUser==null){
            System.out.println("No logged in user found");
            return null;

        }
        if(nameToRestaurantMap.containsKey(name)){
            System.out.println("Restuarent Already exits");  // TODO: Exceptions
            return null;
        }
        List<String> pinCodeLists= Arrays.asList(pincodes.split(","));
        List<Long> pinCodes=new ArrayList<>();
        if(!pinCodeLists.isEmpty()){

            for(String s:pinCodeLists){
                if(!s.chars().allMatch(Character::isDigit)){
                    System.out.println("Invaild Pincodes ");
                    return null;
                }
                pinCodes.add(Long.parseLong(s));
            }
        }
        //TODO : try to implements builder pattern here

        Restaurant restaurant=new Restaurant();
        restaurant.setId(IdGenretor.getId());
        restaurant.setName(name);
        restaurant.setItem(Item);
        restaurant.setPrice(price);
        restaurant.setServicablePincodes(pinCodes);
        restaurant.setQuantity(quantity);
        nameToRestaurantMap.put(name,restaurant);
        // TODO :  we added without checking pincode of user
        loggedInUser.getRestaurants().add(restaurant);
        System.out.println("Successfully registered restaurent with id " + restaurant.getId());
        return restaurant;
    }

    public Review rateRestaurent(String restaurentName,int score,String comment){
        Restaurant restaurant= nameToRestaurantMap.get(restaurentName);
        if(restaurant==null){
            System.out.println("Please enter correct restaurent name");
            return  null;
        }
        Review review=new Review();
        review.setId(IdGenretor.getId());
        review.setComment(comment);
        review.setScore(score);

        if(restaurant.getReviews().isEmpty()){
            restaurant.setRating(Float.valueOf(score));

        }
        else{
            float currentScore=( restaurant.getRating()* restaurant.getReviews().size() + score)/(restaurant.getReviews().size()+1);
            restaurant.setRating(currentScore);
        }
        restaurant.getReviews().add(review);
        return review;
    }

    public Restaurant updateQuntity(String restaurentName,int quantity){
        Restaurant restaurant=nameToRestaurantMap.get(restaurentName);
        if(restaurant==null){
            System.out.println("Please enter correct restaurent name");
            return  null;
        }
        restaurant.setQuantity(quantity);
        return restaurant;
    }

    public List<Restaurant> showRestaurents(String sortBy){
        List<Restaurant> allUserRestaurents=loggedInUser.getRestaurants();
        List<Restaurant> allRestaurentRelatedToPincode=new ArrayList<>();

        for(Restaurant res:allUserRestaurents){
            if(res.getServicablePincodes().contains(loggedInUser.getPincode()) && res.getQuantity()>0){
                allRestaurentRelatedToPincode.add(res);
            }
        }
        if(sortBy.equalsIgnoreCase("rating")){
            Collections.sort(allRestaurentRelatedToPincode,new SortByRating());

            for(Restaurant res:allUserRestaurents){
                System.out.println("Restaurent Id" + res.getId()+ " Restaurent Name "+res.getName()+"Itme "
                        +res.getItem() + " Price "+res.getPrice() +"Rating "+res.getRating()
                );
            }
            return allUserRestaurents;
        }
        else if(sortBy.equalsIgnoreCase("price")){
            Collections.sort(allRestaurentRelatedToPincode,new soryByPrice());
            for(Restaurant res:allUserRestaurents){
                System.out.println("Restaurent Id" + res.getId()+ " Restaurent Name "+res.getName()+"Itme "
                        +res.getItem() + " Price "+res.getPrice() +"Rating "+res.getRating()
                );
            }
            return allUserRestaurents;
        }
        System.out.println("Not a vaild sorting criteria");
        return null;
    }
}





class SortByRating implements Comparator<Restaurant>{
    @Override
    public int compare(Restaurant a,Restaurant b){
        if(a.getRating()==null || b.getRating()==null) return 0;
        if(a.getRating()==b.getRating()) return 0;
        else if(a.getRating()>b.getRating()) return 1;
        else return -1;
    }
}

class soryByPrice implements  Comparator<Restaurant>{

    @Override
    public int compare(Restaurant a,Restaurant b){
        return a.getPrice()-b.getPrice();
    }
}