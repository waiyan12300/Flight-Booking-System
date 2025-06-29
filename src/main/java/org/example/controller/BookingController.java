package org.example.controller;
import org.example.model.*;
import org.example.view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BookingController {
    private List<Flight> flights;
    private List<String> cities;
    private List<Booking> bookings = new ArrayList<>();
    private org.example.view.ConsoleView view;

    public BookingController(ConsoleView view) {
        this.view = view;
        initMockData();
    }

    private void initMockData() {
        cities = Arrays.asList("Japan", "Myanmar", "Thailand");
        flights = new ArrayList<>();

        Route r1 = new Route("Japan", "Myanmar");
        Route r2 = new Route("Japan", "Thailand");
        Route r3 = new Route("Myanmar", "Japan");
        Route r4 = new Route("Myanmar", "Thailand");
        Route r5 = new Route("Thailand", "Myanmar");
        Route r6 = new Route("Thailand", "Japan");


        Flight f1 = new Flight("F101", r1);
        f1.addSeat(new Seat("A1", "Window"));
        f1.addSeat(new Seat("B1", "Aisle"));

        Flight f2 = new Flight("F102", r2);
        f2.addSeat(new Seat("A1", "Window"));
        f2.addSeat(new Seat("B1", "Aisle"));

        Flight f3 = new Flight("F103", r3);
        f3.addSeat(new Seat("A1", "Window"));
        f3.addSeat(new Seat("B1", "Aisle"));

        Flight f4 = new Flight("F104", r4);
        f4.addSeat(new Seat("A1", "Window"));
        f4.addSeat(new Seat("B1", "Aisle"));

        Flight f5 = new Flight("F105", r5);
        f5.addSeat(new Seat("A1", "Window"));
        f5.addSeat(new Seat("B1", "Aisle"));

        Flight f6 = new Flight("F106", r6);
        f6.addSeat(new Seat("A1", "Window"));
        f6.addSeat(new Seat("B1", "Aisle"));

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);
        flights.add(f6);
    }

    public void startBookingFlow() {
        int depIndex = view.selectCityForDeparture(cities);
        String depCity = cities.get(depIndex);

        int destIndex = view.selectCityForDestination(cities, depIndex);
        String destCity = cities.get(destIndex);

        List<Flight> matchedFlights = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getRoute().getDepartureCity().equals(depCity) &&
                    f.getRoute().getDestinationCity().equals(destCity)) {
                matchedFlights.add(f);
            }
        }

        if (matchedFlights.isEmpty()) {
            view.showMessage("No flights found.");
            return;
        }

        List<String> flightNumbers = new ArrayList<>();
        for (Flight flight : matchedFlights) {
            flightNumbers.add(flight.getFlightNumber());
        }
        int choiceFlight = view.selectAvailableFlights(flightNumbers);
        Flight selectedFlight = matchedFlights.get(choiceFlight);

        List<Seat> availableSeats = selectedFlight.getAvailableSeats();
        if (availableSeats.isEmpty()) {
            view.showMessage("No seats available.");
            return;
        }

        List<String> seatNumbers = new ArrayList<>();
        for (Seat seat : availableSeats) {
            seatNumbers.add(seat.toString());
        }
        int choiceSeat = view.selectAvailableSeats(seatNumbers);
        Seat selectedSeat = availableSeats.get(choiceSeat);
        selectedSeat.book();

        String name = view.getCustomerName();
        Customer customer = new Customer(name);
        Ticket ticket = new Ticket(500.0);
        Booking booking = new Booking(customer, selectedFlight, selectedSeat, ticket);
        bookings.add(booking);
        view.showMessage("\n====Booking successful!====");
        view.showMessage(booking.generateSummary());
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            view.showMessage("No bookings found.");
            return;
        }

        view.showMessage("\n=== Your Bookings ===");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i).generateSummary());
        }
    }

    public void cancelBooking() {
        if (bookings.isEmpty()) {
            view.showMessage("No bookings to cancel.");
            return;
        }

        List<String> bookingSummaries = new ArrayList<>();
        for (Booking booking : bookings) {
            bookingSummaries.add(booking.generateSummary());
        }

        int cancelIndex = view.selectBookedSeats(bookingSummaries);
        Booking bookingToCancel = bookings.get(cancelIndex);

        bookingToCancel.getSeat().unbook();

        bookings.remove(cancelIndex);

        view.showMessage("Booking canceled successfully.");
    }

}
