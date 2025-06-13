package src.Zoho3rdRound.FoodOrderingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static int idCounter = 1001; // Start order IDs from 1001
    private int orderId;
    private int userId;
    private int restaurantId;
    private List<OrderItem> items;
    private double totalAmount;
    private String deliveryAddress;
    private OrderStatus status;
    private LocalDateTime orderTime;
    // Add rating field if rating is per order, otherwise manage in Restaurant/Review
    // private int orderRating = 0; // 0 means not rated

    public enum OrderStatus { PLACED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED }

    public Order(int userId, int restaurantId, String deliveryAddress) {
        this.orderId = idCounter++;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = OrderStatus.PLACED; // Initial status
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(MenuItem menuItem, int quantity) {
        // Optional: check if item already exists and update quantity
        boolean found = false;
        for(OrderItem oi : items) {
            if (oi.getItem().getItemId() == menuItem.getItemId()) {
                // For simplicity now, we just add duplicates. A real app might update quantity.
                // oi.setQuantity(oi.getQuantity() + quantity);
                // found = true;
                // break;
            }
        }
        if (!found) { // Or just always add as a new OrderItem entry
            this.items.add(new OrderItem(menuItem, quantity));
        }
        recalculateTotal();
    }

    public void removeItem(int menuItemId) {
        items.removeIf(orderItem -> orderItem.getItem().getItemId() == menuItemId);
        recalculateTotal();
    }


    private void recalculateTotal() {
        this.totalAmount = 0.0;
        for (OrderItem orderItem : items) {
            this.totalAmount += orderItem.getTotalPrice();
        }
    }

    // --- Getters ---
    public int getOrderId() { return orderId; }
    public int getUserId() { return userId; }
    public int getRestaurantId() { return restaurantId; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); } // Return copy
    public double getTotalAmount() { return totalAmount; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getOrderTime() { return orderTime; }

    // --- Setters (Example for status) ---
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String itemsStr = items.stream()
                .map(OrderItem::toString)
                .collect(Collectors.joining("\n"));
        return String.format("Order ID: %d\n User ID: %d\n Restaurant ID: %d\n Address: %s\n Status: %s\n Time: %s\n Total: %.2f\n Items:\n%s",
                orderId, userId, restaurantId, deliveryAddress, status, orderTime.toString(), totalAmount, itemsStr);
    }
}