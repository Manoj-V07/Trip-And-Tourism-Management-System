package com.triporganiser;

import java.util.Objects;

public class Package {
    private int packageId;
    private String destination;
    private String description;
    private double price;
    private int durationDays;
    private int availableSeats;
    private boolean isActive;

    public Package(int packageId, String destination, String description,
                   double price, int durationDays, int availableSeats) {
        this.packageId = packageId;
        setDestination(destination);
        this.description = description;
        setPrice(price);
        setDurationDays(durationDays);
        setAvailableSeats(availableSeats);
        this.isActive = true;
    }

    // Getters
    public int getPackageId() { return packageId; }
    public String getDestination() { return destination; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getDurationDays() { return durationDays; }
    public int getAvailableSeats() { return availableSeats; }
    public boolean isActive() { return isActive; }

    // Setters with validation
    public void setDestination(String destination) {
        if (destination == null || destination.trim().isEmpty())
            throw new IllegalArgumentException("Destination required");
        this.destination = destination;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be > 0");
        this.price = price;
    }

    public void setDurationDays(int durationDays) {
        if (durationDays <= 0) throw new IllegalArgumentException("Duration must be > 0");
        this.durationDays = durationDays;
    }

    public void setAvailableSeats(int seats) {
        if (seats < 0) throw new IllegalArgumentException("Seats cannot be negative");
        this.availableSeats = seats;
    }

    public void setActive(boolean active) { this.isActive = active; }

    public boolean bookSeat() {
        if (availableSeats > 0 && isActive) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() { availableSeats++; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Package)) return false;
        Package p = (Package) o;
        return packageId == p.packageId;
    }

    @Override
    public int hashCode() { return Objects.hash(packageId); }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + packageId +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", days=" + durationDays +
                ", seats=" + availableSeats +
                ", active=" + isActive +
                '}';
    }
}
