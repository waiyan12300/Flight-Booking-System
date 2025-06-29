package org.example.model;

public class Booking {
    private Customer customer;
    private Flight flight;
    private Seat seat;
    private Ticket ticket;

    public Booking(Customer customer, Flight flight, Seat seat, Ticket ticket) {
        this.customer = customer;
        this.flight = flight;
        this.seat = seat;
        this.ticket = ticket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String generateSummary() {
        return "Name: " + customer.getName() +
                "\nFlight: " + flight.getFlightNumber() +
                "\nRoute: " + flight.getRoute() +
                "\nSeat: " + seat +
                "\nTicket Price: $" + ticket.getPrice();
    }
}

