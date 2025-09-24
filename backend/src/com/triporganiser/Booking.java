package com.triporganiser;

public class Booking {

    /* This private instance variable are used to 
    store the states of the Booking Object  */
    private int bookingId;
    private int userId;
    private int packageId;

    /* Constructor method  is called to create or initialize 
    the Booking Object with the given parameters */
    public Booking(int bookingId , int userId , int packageId){
        this.bookingId = bookingId;
        this.userId = userId;
        this.packageId = packageId;
    }

    /* Getter Method To Return The Booking ID */
    public int getBookingId() { return bookingId; } 

    /* Getter Method To Return The User ID */
    public int getUserId() { return userId; }

    /* Getter Method To Return The Package ID */
    public int getPackageId() { return packageId; }

    /* Overrides the default toString method to provide a string representation customly */
    @Override
    public String toString(){
        return "Booking ID: " + bookingId + ", User ID : " + userId +
        ", Package ID : " + packageId;
    }
}