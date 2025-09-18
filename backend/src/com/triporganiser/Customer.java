package com.triporganiser;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Booking> bookings;

    public Customer(int userId, String username, String password, String name, String email) {
        super(userId, username, password, name, email, "customer");
        bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        if (booking != null) bookings.add(booking);
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(b -> b.getBookingId() == bookingId);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", bookingsCount=" + bookings.size() +
                '}';
    }
}
