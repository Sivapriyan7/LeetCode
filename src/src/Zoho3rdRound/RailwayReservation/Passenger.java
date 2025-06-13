package src.Zoho3rdRound.RailwayReservation;

public class Passenger {
    String name;
    int age;
    String gender;
    String berthPreference;
    String allotedBerth;
    String ticketId;

    public Passenger(String name, int age, String gender, String berthPreference, String allotedBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allotedBerth = allotedBerth;
        this.ticketId = ticketId;
    }

    @Override
    public String toString(){
        return "Ticket ID: " + ticketId + ", Name: " + name + ", Age: " + age +
        ", Gender: " + gender + ", Berth: " + allotedBerth;
    }
}
