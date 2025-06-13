package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    private static int idCounter = 1;
    private int restaurantId;
    private String name;
    private String cuisine;
    private String location;
    private List<MenuItem> menu;
    private List<Review> reviews;
    private double averageRating;

    public Restaurant(String name, String cuisine, String location) {
        this.restaurantId = idCounter++;
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.menu = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.averageRating = 0.0; // Initially no ratings
    }

    // --- Menu Management ---
    public void addMenuItem(MenuItem item) {
        this.menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return new ArrayList<>(menu); // Return a copy
    }

    public MenuItem findMenuItemById(int itemId) {
        for (MenuItem item : menu) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    // --- Review Management ---
    public void addReview(Review review) {
        this.reviews.add(review);
        updateAverageRating();
    }

    private void updateAverageRating() {
        if (reviews.isEmpty()) {
            this.averageRating = 0.0;
        } else {
            double totalRating = 0;
            for (Review r : reviews) {
                totalRating += r.getRating();
            }
            this.averageRating = totalRating / reviews.size();
        }
    }

    // --- Getters ---
    public int getRestaurantId() { return restaurantId; }
    public String getName() { return name; }
    public String getCuisine() { return cuisine; }
    public String getLocation() { return location; }
    public double getAverageRating() { return averageRating; }
    public List<Review> getReviews() { return new ArrayList<>(reviews); } // Return a copy

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Cuisine: %s, Location: %s, Rating: %.1f",
                restaurantId, name, cuisine, location, averageRating);
    }

    public String getMenuAsString() {
        if (menu.isEmpty()) {
            return "  Menu is empty.";
        }
        return menu.stream()
                .map(MenuItem::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getReviewsAsString() {
        if (reviews.isEmpty()) {
            return "  No reviews yet.";
        }
        return reviews.stream()
                .map(Review::toString) // Assuming Review has a nice toString()
                .collect(Collectors.joining("\n"));
    }
}