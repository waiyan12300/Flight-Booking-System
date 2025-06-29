package org.example;

import org.example.controller.BookingController;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        BookingController controller = new BookingController(view);
        boolean running = true;

        while (running) {
            int choice = view.showMainMenu();
            switch (choice) {
                case 1:
                    controller.startBookingFlow();
                    break;
                case 2:
                    controller.viewBookings();
                    break;
                case 3:
                    controller.cancelBooking();
                    break;
                case 4:
                    view.showMessage("Goodbye!");
                    running = false;
                    break;
                default:
                    view.showMessage("Invalid option. Try again.");
            }
        }
    }
}
