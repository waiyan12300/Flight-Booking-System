package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private Route route;
    private List<Seat> seats = new ArrayList<>();

    public Flight(String flightNumber, Route route) {
        this.flightNumber = flightNumber;
        this.route = route;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Route getRoute() {
        return route;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat s : seats) {
            if (s.isAvailable())
            {
                availableSeats.add(s);
            }
        }
        return availableSeats;
    }
}

