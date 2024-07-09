import com.company.Service.OrderService;
import com.company.Service.RestarantService;
import com.company.Service.UserService;
import com.company.constant.Gender;
import com.company.model.Order;
import com.company.model.Restaurant;
import com.company.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        UserService user=UserService.getUserInstance();
        RestarantService restaurant=RestarantService.getResInstance();
        OrderService order=OrderService.getOrderInstance();

        User vipin=user.userRegister(8107099646L,"vipin",332021L, Gender.male);
        User srijan =user.userRegister(8825288282L,"srijan",332243L,Gender.male);
        User monika=user.userRegister(324234232L,"monika",332322L,Gender.female);

        User logIn=user.login(vipin.getPhone());
        Restaurant hotelVIP=restaurant.registerRestauerant("hotelVIP","332021,332243","Biryani",200,4 );
        Restaurant hotelKum=restaurant.registerRestauerant("hotelKum","332322,332021","BUrger",100,2 );

        hotelVIP=restaurant.updateQuntity("hotelVIP",10 );

        logIn=user.login(srijan.getPhone());
//        Restaurant kkr= restaurant.registerRestauerant("kkr","33243","nonBIryani",300,4);
        Restaurant kkr= restaurant.registerRestauerant("kkr","332243","nonBIryani",300,4);

        logIn=user.login(monika.getPhone());
        Restaurant mon= restaurant.registerRestauerant("mon","332322,332021","Pizza",180,3);

        logIn=user.login(vipin.getPhone());

//        logIn=user.login(srijan.getPhone());

//        restaurant.showRestaurents("price");
//
//        restaurant.rateRestaurent("hotelVIP",3,"avg");
//        restaurant.rateRestaurent("hotelKum",4,"good");
//        restaurant.showRestaurents("rating");

        order.placeOrder("hotelVIP",8);
         List<Order> allorders= order.allOrder();



    }
}