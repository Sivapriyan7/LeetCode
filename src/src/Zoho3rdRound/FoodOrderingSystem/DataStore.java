package src.Zoho3rdRound.FoodOrderingSystem;

// --- File: DataStore.java ---
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap; // Use ConcurrentHashMap for thread safety if needed later

public class DataStore {
    // Using phone number as key for users for easy login/registration lookup
    public static final Map<String, User> usersByPhoneNumber = new ConcurrentHashMap<>();
    public static final Map<Integer, User> usersById = new ConcurrentHashMap<>();

    public static final Map<Integer, Restaurant> restaurants = new ConcurrentHashMap<>();
    public static final Map<Integer, Order> orders = new ConcurrentHashMap<>();

    // Temporary storage for OTPs (PhoneNumber -> OTP)
    public static final Map<String, String> registrationOtps = new ConcurrentHashMap<>();
    public static final Map<String, String> loginOtps = new ConcurrentHashMap<>();

    // You can add methods here to pre-populate data if needed
    public static void initializeDummyData() {
        // Add Restaurants
        Restaurant r1 = new Restaurant("Pizza Palace", "Italian", "Downtown");
        r1.addMenuItem(new MenuItem("Margherita Pizza", 12.99, "Classic cheese and tomato"));
        r1.addMenuItem(new MenuItem("Pepperoni Pizza", 14.99, "Loaded with pepperoni"));
        r1.addMenuItem(new MenuItem("Garlic Bread", 5.99, "Toasted with garlic butter"));
        restaurants.put(r1.getRestaurantId(), r1);

        Restaurant r2 = new Restaurant("Curry House", "Indian", "Uptown");
        r2.addMenuItem(new MenuItem("Butter Chicken", 15.50, "Creamy tomato curry"));
        r2.addMenuItem(new MenuItem("Veg Biryani", 13.00, "Aromatic rice dish"));
        r2.addMenuItem(new MenuItem("Naan Bread", 3.00, "Tandoor baked flatbread"));
        restaurants.put(r2.getRestaurantId(), r2);

        Restaurant r3 = new Restaurant("Sushi Spot", "Japanese", "Downtown");
        r3.addMenuItem(new MenuItem("California Roll", 8.50, "Crab, avocado, cucumber"));
        r3.addMenuItem(new MenuItem("Tuna Nigiri", 5.00, "Slice of tuna over rice"));
        restaurants.put(r3.getRestaurantId(), r3);

        System.out.println("Dummy data initialized.");
    }
}