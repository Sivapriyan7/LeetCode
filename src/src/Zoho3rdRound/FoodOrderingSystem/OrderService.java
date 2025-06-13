package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.List;
import java.util.Map;

public class OrderService {

    // Corresponds to: place_order(restaurantid, items)
    // 'items' here will be represented as a Map<Integer, Integer> (itemId -> quantity)
    // Needs the logged-in user
    public Order placeOrder(User user, int restaurantId, Map<Integer, Integer> itemQuantities) {
        if (user == null) {
            System.out.println("Error: Please login to place an order.");
            return null;
        }
        Restaurant restaurant = DataStore.restaurants.get(restaurantId);
        if (restaurant == null) {
            System.out.println("Error: Restaurant not found.");
            return null;
        }
        if (itemQuantities == null || itemQuantities.isEmpty()) {
            System.out.println("Error: Cannot place an empty order.");
            return null;
        }

        Order newOrder = new Order(user.getUserId(), restaurantId, user.getAddress()); // Use user's registered address

        for (Map.Entry<Integer, Integer> entry : itemQuantities.entrySet()) {
            int itemId = entry.getKey();
            int quantity = entry.getValue();
            MenuItem menuItem = restaurant.findMenuItemById(itemId);

            if (menuItem == null) {
                System.out.println("Error: Item with ID " + itemId + " not found in restaurant menu. Order cancelled.");
                return null; // Cancel the whole order if one item is invalid
            }
            if (quantity <= 0) {
                System.out.println("Warning: Item ID " + itemId + " has invalid quantity " + quantity + ". Skipping item.");
                continue; // Skip items with invalid quantity
            }
            newOrder.addItem(menuItem, quantity);
        }

        if (newOrder.getItems().isEmpty()){
            System.out.println("Error: No valid items found in the order request. Order cancelled.");
            return null;
        }

        // Order successfully created with items
        DataStore.orders.put(newOrder.getOrderId(), newOrder);
        user.addOrderToHistory(newOrder); // Add to user's history

        System.out.println("--------------------------------------------------");
        System.out.println("Order Placed Successfully!");
        System.out.println(newOrder); // Print order details
        System.out.println("--------------------------------------------------");

        // Simulate order processing (can be expanded later)
        // newOrder.setStatus(Order.OrderStatus.PREPARING);

        return newOrder;
    }

    public Order getOrderById(int orderId) {
        return DataStore.orders.get(orderId);
    }

    // Add order tracking and cancellation later if needed
    public void trackOrder(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            System.out.printf("Order #%d Status: %s\n", orderId, order.getStatus());
        } else {
            System.out.println("Order not found.");
        }
    }

    // Basic cancellation - only if status is PLACED (or PREPARING maybe)
    public boolean cancelOrder(User user, int orderId) {
        Order order = getOrderById(orderId);
        if (order == null) {
            System.out.println("Error: Order not found.");
            return false;
        }
        if (user == null || order.getUserId() != user.getUserId()) {
            System.out.println("Error: Cannot cancel an order you did not place.");
            return false;
        }
        // Define cancellation policy (e.g., only possible if status is PLACED)
        if (order.getStatus() == Order.OrderStatus.PLACED /* || order.getStatus() == Order.OrderStatus.PREPARING */ ) {
            order.setStatus(Order.OrderStatus.CANCELLED);
            System.out.printf("Order #%d has been cancelled.\n", orderId);
            // Potentially remove from user history or mark as cancelled there too
            return true;
        } else {
            System.out.printf("Error: Order #%d cannot be cancelled at its current status (%s).\n", orderId, order.getStatus());
            return false;
        }
    }
}