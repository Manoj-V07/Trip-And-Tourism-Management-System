package com.triporganiser;

public class Package {
    private int packageId;
    private String destination;
    private String description;
    private double price;
    private int duration;
    private int availableSeats;

    public Package(int packageId, String destination, String description, double price, int duration, int availableSeats) {
        this.packageId = packageId;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getPackageId() { return packageId; }
    public String getDestination() { return destination; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getDuration() { return duration; }
    public int getAvailableSeats() { return availableSeats; }

    public void reduceSeats() {
        if (availableSeats > 0) availableSeats--;
    }

    public void increaseSeats() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return "Package ID: " + packageId +
                ", Destination: " + destination +
                ", Price: " + price +
                ", Duration: " + duration + " days" +
                ", Available Seats: " + availableSeats +
                ", Description: " + description;
    }
}
