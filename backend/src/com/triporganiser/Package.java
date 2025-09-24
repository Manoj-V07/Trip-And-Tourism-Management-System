package com.triporganiser;

public class Package{
    private int packageId;
    private String destination;
    private String description;
    private double price;
    private int duration;
    private int availableSeats;

    /* Package Constructor used to initialize the object */
    public Package(int packageId , String destination , String description , double price , int duration , int availableSeats){
        this.packageId = packageId;
        this.destination  = destination;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    /*Getters Function*/
    public int getPackageId() {return packageId; }
    public String getDestination() {return destination; }
    public String getDescription() { return description; }
    public double getprice() { return price; }
    public int getDuration() { return duration; }
    public int getAvailableSeats() { return availableSeats; }

    /*When Update Package is Performed then Setter Plays the Major Role */
    public void setDestination(String destination) { this.destination = destination; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public void reduceSeats(){
        if(availableSeats > 0){    /* Decrement The Seats */
            availableSeats--;
        }
    }
    public void increaseSeats(){
        availableSeats++;         /* Increment The Seats */
    }

    @Override
    public String toString(){
        return "Package ID : " + packageId +
        ", Destination : " + destination +
        ", Price : " + price + 
        "Duration : " + duration +  " Days" +
        ", Availale Seats : " + availableSeats +
        ", Description : " + description;
    }
}