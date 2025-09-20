package com.triporganiser;

public class Booking {
    private int bookingId;
    private int userId;
    private int packageId;

    public Booking(int bookingId, int userId, int packageId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.packageId = packageId;
    }

    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public int getPackageId() { return packageId; }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", User ID: " + userId + ", Package ID: " + packageId;
    }
}
