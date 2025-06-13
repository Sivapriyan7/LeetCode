package src.Zoho3rdRound.FoodOrderingSystem;

public class OrderItem {
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return item.getPrice() * quantity; }

    @Override
    public String toString() {
        return String.format("   Item: %s (ID: %d), Qty: %d, Price: %.2f",
                item.getName(), item.getItemId(), quantity, getTotalPrice());
    }
}
