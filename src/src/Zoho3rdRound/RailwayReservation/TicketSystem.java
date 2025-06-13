package src.Zoho3rdRound.RailwayReservation;

import java.util.*;

public class TicketSystem {
    private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "U", "M"));
    private final Queue<Passenger> racQueue = new LinkedList<>();
    private final Queue<Passenger> waitingListQueue = new LinkedList<>();
    private final List<Passenger> confirmedPassengers = new ArrayList<>();
    private int ticketCounter = 1;

    public void bookTicket(String name, int age, String gender, String berthPreference){
        String ticketId = "T" + ticketCounter++;
        Passenger passenger;
        if(!availableBerths.isEmpty()){
            String allocatedBerth = allocatedBerth(age, gender, berthPreference);
            passenger = new Passenger(name,age,gender,berthPreference,allocatedBerth,ticketId);
            confirmedPassengers.add(passenger);
            availableBerths.remove(allocatedBerth);
            System.out.println("Ticket Confirmed: " + passenger);
        }
        else if (racQueue.size() < 1){
            passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
            racQueue.offer(passenger); //add to tail of queue
            System.out.println("Ticket in RAC: " + passenger);
        }
        else if (waitingListQueue.size() < 1){
            passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in Waiting List: "+ passenger);
        }
        else {
            //If Berth, RAC and waiting list are fill, then
            System.out.println("No tickets available.");
        }
    }

    private String allocatedBerth(int age, String gender, String preference){
        if(age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L"))
        {
            return "L";
        }
        if (availableBerths.contains(preference)){
            return preference;
        }
        return availableBerths.get(0);
    }

    public void cancelTicket(String ticketId){
        Optional<Passenger> passengerOpt = confirmedPassengers.stream()
                .filter(passenger -> passenger.ticketId.equals(ticketId))
                .findFirst();
        if(passengerOpt.isPresent()) {
            Passenger passenger = passengerOpt.get();
            confirmedPassengers.remove(passenger);
            availableBerths.add(passenger.allotedBerth);
            if (!racQueue.isEmpty()) {
                Passenger racPassenger = racQueue.poll();
                String allocatedBerth = allocatedBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
                racPassenger.allotedBerth = allocatedBerth;
                confirmedPassengers.add(racPassenger);
                availableBerths.remove(allocatedBerth);
                System.out.println("RAC Ticket moved to confirmed: " + racPassenger);
            }

            if (!waitingListQueue.isEmpty()) {
                Passenger waitingPassenger = waitingListQueue.poll();
                racQueue.offer(waitingPassenger);
                waitingPassenger.allotedBerth = "RAC";
                System.out.println("Waiting List ticket moved to RAC: " + waitingPassenger);
            }
            System.out.println("Ticket Cancelled Successfully for ID: " + ticketId);
        }
        else {
            System.out.println("No ticket found with ID: "+ticketId);
        }
    }

    public void printBookedTickets(){
        if(confirmedPassengers.isEmpty()){
            System.out.println("No confirmed Tickets.");
        }
        else {
            System.out.println("Confirmed Tickets:");
            //Iterate through the confirmed Passengers and print each
            for (Passenger passenger: confirmedPassengers)
            {
                System.out.println(passenger);
            }
        }
    }

    public void printAvailableTickets(){
        System.out.println("Available Berths: " + availableBerths.size());
        System.out.println("Available RAC Tickets: " + (1-racQueue.size()));
        System.out.println("Available Waiting List Tickets: " + (1-waitingListQueue.size()));

    }

    public void viewRacTickets(){
        if(racQueue.isEmpty()){
            System.out.println("No RAC tickets.");
        }
        else {
            System.out.println("RAC Tickets:");
            for (Passenger passenger: racQueue)
            {
                System.out.println(passenger);
            }
        }
    }

    public void viewWaitingListTickets(){
        if(waitingListQueue.isEmpty()){
            System.out.println("No Waiting List tickets");
        }
        else{
            System.out.println("Waiting List Tickets:");
            for (Passenger passenger: waitingListQueue){
                System.out.println(passenger);
            }
        }
    }
}
