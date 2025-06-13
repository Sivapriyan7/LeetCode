package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService {

    // Corresponds to: seach_restaurant(location*, cuisine, rating)
    public List<Restaurant> searchRestaurants(String location, String cuisine, int minRating) {
        return DataStore.restaurants.values().stream()
                .filter(r -> r.getLocation().equalsIgnoreCase(location)) // Location mandatory and case-insensitive
                .filter(r -> cuisine == null || cuisine.isEmpty() || r.getCuisine().equalsIgnoreCase(cuisine)) // Optional cuisine filter
                .filter(r -> minRating <= 0 || r.getAverageRating() >= minRating) // Optional rating filter (0 or less ignores)
                .collect(Collectors.toList());
    }

    public Restaurant getRestaurantById(int restaurantId) {
        return DataStore.restaurants.get(restaurantId);
    }


    // Corresponds to: review_restaurant(restaurantid, rating, review)
    // Needs the logged-in user to associate the review
    public boolean addRestaurantReview(User user, int restaurantId, int rating, String reviewText) {
        Restaurant restaurant = DataStore.restaurants.get(restaurantId);
        if (restaurant == null) {
            System.out.println("Error: Restaurant not found.");
            return false;
        }
        if (user == null) {
            System.out.println("Error: User not logged in.");
            return false;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
            return false;
        }

        Review review = new Review(user.getUserId(), restaurantId, rating, reviewText);
        restaurant.addReview(review); // This also updates the average rating
        System.out.println("Review added successfully for " + restaurant.getName());
        return true;
    }

    // Corresponds to: rate_order(restaurantid, orderld, rating)
    // This seems more like rating the *experience* (restaurant) for a specific *order*.
    // Let's implement it by adding a review linked to the order.
    public boolean rateOrderExperience(User user, int restaurantId, int orderId, int rating) {
        Restaurant restaurant = DataStore.restaurants.get(restaurantId);
        Order order = DataStore.orders.get(orderId);

        if (restaurant == null) {
            System.out.println("Error: Restaurant not found.");
            return false;
        }
        if (order == null) {
            System.out.println("Error: Order not found.");
            return false;
        }
        if (user == null || order.getUserId() != user.getUserId()) {
            System.out.println("Error: Cannot rate an order you did not place.");
            return false;
        }
        if (order.getRestaurantId() != restaurantId) {
            System.out.println("Error: Order does not belong to the specified restaurant.");
            return false;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Error: Rating must be between 1 and 5.");
            return false;
        }

        // Add a review specifically linked to this order
        // We'll add a simple review text indicating it's an order rating.
        String reviewText = "Rating for order #" + orderId;
        Review review = new Review(user.getUserId(), restaurantId, orderId, rating, reviewText);
        restaurant.addReview(review); // Updates average rating
        System.out.printf("Rating of %d added for order #%d at %s.\n", rating, orderId, restaurant.getName());

        // Optional: Mark the order itself as rated if needed
        // order.setOrderRating(rating); // If you add a rating field to Order

        return true;
    }

}