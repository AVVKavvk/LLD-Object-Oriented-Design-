# Foodkart

## Description

Foodkart is an online food ordering service developed by Flipkart. In this service, users can order food from restaurants that serve in their area, and the restaurant will deliver the food.

### Features

- Restaurants can only serve one specialized dish.
- Restaurants can serve in multiple areas.
- Users can order from one restaurant at a time, with the quantity of food being more than one.
- Users can rate any restaurant with or without a comment.
- The rating of a restaurant is the average rating given by all customers.

### Requirements

1. **Register a User**: `register_user(user_details)`
   - `user_details`: name, gender, phoneNumber (unique), and pincode.
   
2. **Login a User**: `login_user(user_id)`
   - Sets the context for all subsequent operations to be done by this user. If another user logs in, the previous user is automatically logged out.
   
3. **Register a Restaurant**: `register_restaurant(restaurant_name, serviceable_pincodes, food_item_name, food_item_price, initial_quantity)`
   - Registers a restaurant in the context of the logged-in user.
   
4. **Update Quantity**: `update_quantity(restaurant_name, quantity_to_add)`
   - Increases the quantity of the food item.
   
5. **Rate a Restaurant**: `rate_restaurant(restaurant_name, rating, comment)`
   - Users can rate (1-5) any restaurant with or without a comment.
   
6. **Show Serviceable Restaurants**: `show_restaurant(criteria)`
   - Returns a list of all serviceable restaurants, food item name, and price in descending order based on the specified criteria (rating/price).
   
7. **Place an Order**: `place_order(restaurant_name, quantity)`
   - Places an order from any restaurant with any allowed quantity.
   
8. **Order History (Bonus)**: 
   - Fetches the order history of a user.

### Other Details

- Uses in-memory storage; no database or NoSQL store is used.
- No UI is created for the application.
- A driver class is provided for demonstration purposes, executing all commands in one place in the code and including test cases.

### Expectations

- Code should be demoable.
- Maintain good separation of concerns.
- Ensure the code is modular and follows Object-Oriented design principles.
- Handle edge cases properly and fail gracefully.
- Ensure code readability and follow good coding practices.

## Sample Test Case

```java
public class Main {
    public static void main(String[] args) {
        Foodkart foodkart = new Foodkart();

        // Register Users
        foodkart.register_user("Pralove", "M", "phoneNumber-1", "HSR");
        foodkart.register_user("Nitesh", "M", "phoneNumber-2", "BTM");
        foodkart.register_user("Vatsal", "M", "phoneNumber-3", "BTM");

        // User login and restaurant registration
        foodkart.login_user("phoneNumber-1");
        foodkart.register_restaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
        foodkart.register_restaurant("Food Court-2", "BTM", "Burger", 120, 3);

        foodkart.login_user("phoneNumber-2");
        foodkart.register_restaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

        foodkart.login_user("phoneNumber-3");
        foodkart.show_restaurant("price");

        // Place order
        foodkart.place_order("Food Court-1", 2);  // Output: Order Placed Successfully.
        foodkart.place_order("Food Court-2", 7);  // Output: Cannot place order

        // Create reviews
        foodkart.rate_restaurant("Food Court-2", 3, "Good Food");
        foodkart.rate_restaurant("Food Court-1", 5, "Nice Food");

        foodkart.show_restaurant("rating");

        foodkart.login_user("phoneNumber-1");
        foodkart.update_quantity("Food Court-2", 5);  // Output: Food Court-2, BTM, Burger - 8
    }
}
