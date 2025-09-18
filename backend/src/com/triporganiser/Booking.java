package com.triporganiser;

import java.sql.Date;
import java.util.Objects;

public class Booking {
    private int bookingId;
    private int userId;
    private int packageId;
    private Date bookingDate;
    private String status;
    private double totalAmount;

    public Booking(int bookingId, int userId, int packageId, Date bookingDate, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.packageId = packageId;
        this.bookingDate = bookingDate;
        setStatus(status);
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public int getPackageId() { return packageId; }
    public Date getBookingDate() { return bookingDate; }
    public String getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }

    // Setters
    public void setStatus(String status) {
        if (!"booked".equals(status) && !"cancelled".equals(status))
            throw new IllegalArgumentException("Status must be 'booked' or 'cancelled'");
        this.status = status;
    }

    public void setTotalAmount(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        this.totalAmount = amount;
    }

    public boolean isActive() { return "booked".equals(status); }

    public void cancel() { this.status = "cancelled"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking b = (Booking) o;
        return bookingId == b.bookingId;
    }

    @Override
    public int hashCode() { return Objects.hash(bookingId); }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + bookingId +
                ", userId=" + userId +
                ", packageId=" + packageId +
                ", date=" + bookingDate +
                ", status='" + status + '\'' +
                ", amount=" + totalAmount +
                '}';
    }
}
