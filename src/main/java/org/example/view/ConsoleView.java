package org.example.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("\n=== Welcome to Flight Booking System ===");
        System.out.println("1. New Booking");
        System.out.println("2. View Bookings");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Exit");
        System.out.print("Choose: ");
        return scanner.nextInt();
    }

    public int selectCityForDeparture(List<String> cities) {
        int choiceDepCity;
        while (true) {
            System.out.println("\nSelect Departure City:");
            for (int i = 0; i < cities.size(); i++) {
                System.out.println((i + 1) + ". " + cities.get(i));
            }
            System.out.print("Enter choice: ");
            choiceDepCity = scanner.nextInt() - 1;

            if (choiceDepCity >= 0 && choiceDepCity < cities.size()) {
                return choiceDepCity;
            } else {
                System.out.println("Invalid choice. Please select a valid city.");
            }
        }
    }

    public int selectCityForDestination(List<String> cities, int skipIndex) {
        int choiceDestCity;
        while (true) {
            System.out.println("\nSelect Destination City:");
            for (int i = 0; i < cities.size(); i++) {
                if (i == skipIndex) continue;
                System.out.println((i + 1) + ". " + cities.get(i));
            }
            System.out.print("Enter choice: ");
            choiceDestCity = scanner.nextInt() - 1;

            if (choiceDestCity >= 0 && choiceDestCity < cities.size() && choiceDestCity != skipIndex) {
                return choiceDestCity;
            } else {
                System.out.println("Invalid choice. Please select a valid city.");
            }
        }
    }

    public int selectAvailableFlights(List<String> flights) {
        int choiceFlight;
        while (true) {
            System.out.println("\nAvailable Flights:");
            for (int i = 0; i < flights.size(); i++) {
                System.out.println((i + 1) + ". " + flights.get(i));
            }
            System.out.print("Choose: ");
            choiceFlight = scanner.nextInt() - 1;

            if (choiceFlight >= 0 && choiceFlight < flights.size()) {
                return choiceFlight;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public int selectBookedSeats(List<String> bookingSummaries) {
        int cancelBooking;
        while (true) {
            System.out.println("\nSelect booking to cancel:");
            for (int i = 0; i < bookingSummaries.size(); i++) {
                System.out.println((i + 1) + ". " + bookingSummaries.get(i));
            }
            System.out.print("Choose: ");
            cancelBooking = scanner.nextInt() - 1;

            if (cancelBooking >= 0 && cancelBooking < bookingSummaries.size()) {
                return cancelBooking;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public int selectAvailableSeats(List<String> seats) {
        int choiceSeat;
        while (true) {
            System.out.println("\nAvailable Seats:");
            for (int i = 0; i < seats.size(); i++) {
                System.out.println((i + 1) + ". " + seats.get(i));
            }
            System.out.print("Choose: ");
            choiceSeat = scanner.nextInt() - 1;

            if (choiceSeat >= 0 && choiceSeat < seats.size()) {
                return choiceSeat;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public String getCustomerName() {
        scanner.nextLine(); // clear newline
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
