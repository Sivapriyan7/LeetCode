package src.Zoho3rdRound.FoodOrderingSystem;

// --- File: FoodAppConsole.java ---
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoodAppConsole {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final RestaurantService restaurantService = new RestaurantService();
    private static final OrderService orderService = new OrderService();
    private static User loggedInUser = null; // Track logged-in user

    public static void main(String[] args) {
        System.out.println("Initializing Food Delivery App...");
        DataStore.initializeDummyData(); // Load sample restaurants

        while (true) {
            if (loggedInUser == null) {
                showLoginRegisterMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void showLoginRegisterMenu() {
        System.out.println("\n===== Welcome to FoodApp =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        int choice = readIntInput();

        switch (choice) {
            case 1:
                handleRegistration();
                break;
            case 2:
                handleLogin();
                break;
            case 3:
                System.out.println("Exiting application. Goodbye!");
                scanner.close(); // Close scanner before exiting
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showUserMenu() {
        System.out.println("\n===== FoodApp Menu =====");
        System.out.printf("Logged in as: %s (%s)\n", loggedInUser.getUserName(), loggedInUser.getPhoneNumber());
        System.out.println("1. Search Restaurants");
        System.out.println("2. Place Order");
        System.out.println("3. Rate Previous Order Experience");
        System.out.println("4. Review a Restaurant");
        System.out.println("5. View My Orders");
        System.out.println("6. Cancel Order");
        System.out.println("7. Track Order"); // Added based on requirements
        System.out.println("8. Logout");
        System.out.print("Choose an option: ");

        int choice = readIntInput();

        switch (choice) {
            case 1:
                handleRestaurantSearch();
                break;
            case 2:
                handlePlaceOrder();
                break;
            case 3:
                handleRateOrder();
                break;
            case 4:
                handleReviewRestaurant();
                break;
            case 5:
                handleViewMyOrders();
                break;
            case 6:
                handleCancelOrder();
                break;
            case 7:
                handleTrackOrder();
                break;
            case 8:
                loggedInUser = null;
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // --- Input Helper ---
    private static int readIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private static double readDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a decimal number: ");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private static String readStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }


    // --- Handler Methods ---

    private static void handleRegistration() {
        System.out.println("\n--- User Registration ---");
        String phone = readStringInput("Enter Phone Number: ");
        // In a real app, check phone format validity

        // Check if already registered before sending OTP
        if (DataStore.usersByPhoneNumber.containsKey(phone)){
            System.out.println("This phone number is already registered. Please login.");
            return;
        }

        // Generate and "send" OTP for registration verification
        String regOtp = OtpService.generateOtp();
        DataStore.registrationOtps.put(phone, regOtp); // Store for verification
        OtpService.sendOtp(phone, regOtp);

        String enteredOtp = readStringInput("Enter OTP received: ");

        if (userService.verifyRegistrationOtp(phone, enteredOtp)) {
            System.out.println("OTP Verified!");
            String name = readStringInput("Enter User Name: ");
            String email = readStringInput("Enter Email Address: ");
            String address = readStringInput("Enter Delivery Address: ");
            userService.registerUser(phone, name, email, address);
        } else {
            System.out.println("Registration failed: Invalid OTP.");
        }
    }

    private static void handleLogin() {
        System.out.println("\n--- User Login ---");
        String phone = readStringInput("Enter Phone Number: ");

        if (userService.generateLoginOtp(phone)) { // Only proceed if user exists
            String enteredOtp = readStringInput("Enter OTP received: ");
            loggedInUser = userService.loginUser(phone, enteredOtp);
            // loggedInUser will be null if login fails, handled in main loop
        }
        // Error message for non-existent user handled in generateLoginOtp
    }

    private static void handleRestaurantSearch() {
        System.out.println("\n--- Search Restaurants ---");
        String location = readStringInput("Enter Location (e.g., Downtown, Uptown): ");
        String cuisine = readStringInput("Enter Cuisine (leave blank for any): ");
        System.out.print("Enter Minimum Rating (1-5, 0 for any): ");
        int rating = readIntInput();
        if (rating < 0 || rating > 5) {
            System.out.println("Invalid rating. Searching for any rating.");
            rating = 0;
        }


        List<Restaurant> results = restaurantService.searchRestaurants(location, cuisine.isEmpty() ? null : cuisine, rating);

        if (results.isEmpty()) {
            System.out.println("No restaurants found matching your criteria.");
        } else {
            System.out.println("Found Restaurants:");
            results.forEach(System.out::println); // Uses Restaurant's toString()
        }
    }

    private static void handlePlaceOrder() {
        System.out.println("\n--- Place Order ---");
        System.out.print("Enter Restaurant ID to order from: ");
        int restId = readIntInput();
        Restaurant restaurant = restaurantService.getRestaurantById(restId);

        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Menu:");
        System.out.println(restaurant.getMenuAsString());

        Map<Integer, Integer> itemsToOrder = new HashMap<>();
        while (true) {
            System.out.print("Enter Item ID to add (or 0 to finish): ");
            int itemId = readIntInput();
            if (itemId == 0) {
                break;
            }

            MenuItem item = restaurant.findMenuItemById(itemId);
            if (item == null) {
                System.out.println("Invalid Item ID.");
                continue;
            }

            System.out.printf("Enter quantity for %s: ", item.getName());
            int quantity = readIntInput();
            if (quantity <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }

            itemsToOrder.put(itemId, quantity); // Add or update quantity
            System.out.printf("Added %d x %s to cart.\n", quantity, item.getName());
        }

        if (itemsToOrder.isEmpty()) {
            System.out.println("No items selected. Order cancelled.");
            return;
        }

        // Confirm order? (Optional)
        System.out.println("Review your order:");
        double tempTotal = 0;
        for (Map.Entry<Integer, Integer> entry : itemsToOrder.entrySet()) {
            MenuItem item = restaurant.findMenuItemById(entry.getKey());
            if(item != null){ // Should not be null here based on previous checks
                double itemTotal = item.getPrice() * entry.getValue();
                System.out.printf("  %d x %s (ID:%d) @ %.2f = %.2f\n", entry.getValue(), item.getName(), item.getItemId(), item.getPrice(), itemTotal);
                tempTotal += itemTotal;
            }
        }
        System.out.printf("Estimated Total: %.2f\n", tempTotal);
        String confirm = readStringInput("Confirm order? (yes/no): ");

        if(confirm.equalsIgnoreCase("yes")) {
            orderService.placeOrder(loggedInUser, restId, itemsToOrder);
        } else {
            System.out.println("Order cancelled by user.");
        }

    }

    private static void handleRateOrder() {
        System.out.println("\n--- Rate Order Experience ---");
        handleViewMyOrders(); // Show orders first to help user choose

        System.out.print("Enter Order ID to rate: ");
        int orderId = readIntInput();
        Order order = orderService.getOrderById(orderId);

        if (order == null || order.getUserId() != loggedInUser.getUserId()) {
            System.out.println("Invalid Order ID or order does not belong to you.");
            return;
        }

        int restId = order.getRestaurantId();

        System.out.print("Enter Rating (1-5): ");
        int rating = readIntInput();

        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Must be between 1 and 5.");
            return;
        }

        restaurantService.rateOrderExperience(loggedInUser, restId, orderId, rating);
    }

    private static void handleReviewRestaurant() {
        System.out.println("\n--- Review a Restaurant ---");
        System.out.print("Enter Restaurant ID to review: ");
        int restId = readIntInput();

        Restaurant restaurant = restaurantService.getRestaurantById(restId);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        System.out.println("Reviewing: " + restaurant.getName());

        System.out.print("Enter Rating (1-5): ");
        int rating = readIntInput();
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Must be between 1 and 5.");
            return;
        }

        String reviewText = readStringInput("Enter your review text: ");

        restaurantService.addRestaurantReview(loggedInUser, restId, rating, reviewText);
    }

    private static void handleViewMyOrders() {
        System.out.println("\n--- My Order History ---");
        List<Order> orders = loggedInUser.getOrderHistory();
        if (orders.isEmpty()) {
            System.out.println("You have no past orders.");
        } else {
            // Print in reverse chronological order (newest first)
            for (int i = orders.size() - 1; i >= 0; i--) {
                System.out.println("--------------------");
                System.out.println(orders.get(i)); // Uses Order's toString()
            }
            System.out.println("--------------------");
        }
    }

    private static void handleCancelOrder() {
        System.out.println("\n--- Cancel Order ---");
        handleViewMyOrders(); // Show orders to help user choose

        System.out.print("Enter Order ID to cancel: ");
        int orderId = readIntInput();

        orderService.cancelOrder(loggedInUser, orderId);
    }

    private static void handleTrackOrder() {
        System.out.println("\n--- Track Order ---");
        System.out.print("Enter Order ID to track: ");
        int orderId = readIntInput();
        // In this simple simulation, we just show the stored status
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }
        // Security check: Ensure the logged-in user placed this order
        if (order.getUserId() != loggedInUser.getUserId()) {
            System.out.println("You can only track your own orders.");
            return;
        }

        System.out.printf("Tracking Order #%d:\n", orderId);
        System.out.printf(" Status: %s\n", order.getStatus());
        System.out.printf(" Restaurant ID: %d\n", order.getRestaurantId());
        System.out.printf(" Placed at: %s\n", order.getOrderTime());
        System.out.printf(" Delivery Address: %s\n", order.getDeliveryAddress());
        // In a real system, you'd have more detailed tracking info (driver location etc.)
    }
}