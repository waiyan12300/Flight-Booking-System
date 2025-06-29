package org.example.model;

public class Route {
    private String departureCity;
    private String destinationCity;

    public Route(String departureCity, String destinationCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    @Override
    public String toString() {
        return departureCity + " -> " + destinationCity;
    }
}

