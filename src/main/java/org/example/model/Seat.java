package org.example.model;

public class Seat {
    private String seatNumber;
    private String type;
    private boolean isAvailable = true;

    public Seat(String seatNumber, String type) {
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        this.isAvailable = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getType() {
        return type;
    }

    public void unbook() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return seatNumber + " (" + type + ")";
    }
}

