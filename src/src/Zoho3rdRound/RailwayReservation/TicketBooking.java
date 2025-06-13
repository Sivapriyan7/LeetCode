package src.Zoho3rdRound.RailwayReservation;

import java.util.*;

public class TicketBooking {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("\nRailway Booking System:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Confirmed Tickets");
            System.out.println("4. View Available Tickets");
            System.out.println("5. View RAC Tickets");
            System.out.println("6. View Waiting List Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Gender (Male/Female): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Berth Preference (L/U/M): ");
                    String berthPreference = sc.nextLine();
                    //calls the bookTicket class of TicketSystem class
                    ticketSystem.bookTicket(name, age, gender, berthPreference);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    String ticketId = sc.nextLine();
                    ticketSystem.cancelTicket(ticketId);
                    break;
                case 3:
                    ticketSystem.printBookedTickets();
                    break;
                case 4:
                    ticketSystem.printAvailableTickets();
                    break;
                case 5:
                    ticketSystem.viewRacTickets();
                    break;
                case 6:
                    ticketSystem.viewWaitingListTickets();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
