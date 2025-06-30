package org.example.model;

public class Route {
    private String departureCity;
    private String destinationCity;
    private double distance;

    public Route(String departureCity, String destinationCity, double distance) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.distance = distance;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return departureCity + " -> " + destinationCity;
    }
}

