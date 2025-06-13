package src.Zoho3rdRound.FoodOrderingSystem;

public class Review {
    private static int idCounter = 501;
    private int reviewId;
    private int userId;
    private int restaurantId;
    private int orderId; // Optional: link review to a specific order
    private int rating; // 1 to 5
    private String reviewText;

    // Constructor for general restaurant review
    public Review(int userId, int restaurantId, int rating, String reviewText) {
        this(userId, restaurantId, 0, rating, reviewText); // No specific order ID
    }

    // Constructor for review linked to an order
    public Review(int userId, int restaurantId, int orderId, int rating, String reviewText) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        this.reviewId = idCounter++;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    // Getters
    public int getReviewId() { return reviewId; }
    public int getUserId() { return userId; }
    public int getRestaurantId() { return restaurantId; }
    public int getOrderId() { return orderId; }
    public int getRating() { return rating; }
    public String getReviewText() { return reviewText; }

    @Override
    public String toString() {
        String orderInfo = (orderId > 0) ? " (Order #" + orderId + ")" : "";
        return String.format("  Review ID: %d, User ID: %d%s, Rating: %d, Review: %s",
                reviewId, userId, orderInfo, rating, reviewText);
    }
}