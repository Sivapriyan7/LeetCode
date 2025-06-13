package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 1;
    private int userId;
    private String phoneNumber; // Primary identifier for login/registration
    private String userName;
    private String emailAddress;
    private String address;
    private List<Order> orderHistory; // Keep track of user's orders

    public User(String phoneNumber, String userName, String emailAddress, String address) {
        this.userId = idCounter++;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.orderHistory = new ArrayList<>();
    }

    // Getters (and potentially setters if needed later)
    public int getUserId() { return userId; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getUserName() { return userName; }
    public String getEmailAddress() { return emailAddress; }
    public String getAddress() { return address; }
    public List<Order> getOrderHistory() { return orderHistory; }

    public void addOrderToHistory(Order order) {
        this.orderHistory.add(order);
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + "]";
    }
}
