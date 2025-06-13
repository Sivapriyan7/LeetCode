package src.Zoho3rdRound.FoodOrderingSystem;

public class MenuItem {
    private static int idCounter = 101; // Start item IDs from 101
    private int itemId;
    private String name;
    private double price;
    private String description;

    public MenuItem(String name, double price, String description) {
        this.itemId = idCounter++;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("  ID: %d, Name: %s, Price: %.2f, Desc: %s", itemId, name, price, description);
    }
}