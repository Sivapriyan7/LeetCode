package src.Zoho3rdRound.TaxiBooking;

class Booking {
    int bookingId, customerId, pickupTime, dropTime, amount;
    char from, to;

    public Booking(int bookingId, int customerId,  char from, char to,int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.from = from;
        this.amount = amount;
        this.to = to;
    }
}
