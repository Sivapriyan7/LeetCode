package src.Zoho3rdRound.FlightTicketBooking;

import java.util.Scanner;

public class FlightBooking {
    public static void main(String[] args) {

        FlightReservationSystem system = new FlightReservationSystem();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n---- Flight Reservation System----");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Flight Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter flight name (Indigo/SpiceJet): ");
                    String flightName = sc.nextLine();

                    if(system.flights.containsKey(flightName)){
                        system.displayFlightDetails(flightName);
                        System.out.println("Enter Passenger Name: ");
                        String passengerName = sc.nextLine();
                        System.out.println("Enter passenger age: ");
                        int age = sc.nextInt();
                        System.out.println("Enter number of seats to book: ");
                        int seats = sc.nextInt();
                        //The below function returns the bookingId.
                        String bookingId = system.bookTicket(flightName, passengerName, age, seats);
                        if(bookingId != null){
                            System.out.println("Booking Successful! Your booking ID is: " + bookingId);
                        }
                        else {
                            System.out.println("Invalid Flight name, Please try again.");
                        }
                        break;
                    }
                case 2:
                    System.out.println("Enter flight name (Indigo/SpiceJet): ");
                    flightName = sc.nextLine();
                    System.out.println("Enter booking ID: ");
                    String bookingId = sc.nextLine();

                    system.cancelTicket(flightName,bookingId);
                    break;
                case 3:
                    System.out.println("Enter flight name (Indigo/SpiceJet): ");
                    flightName = sc.nextLine();
                    system.printFlightDetails(flightName);
                    break;
                case 4:
                    System.out.println("Exiting....Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
