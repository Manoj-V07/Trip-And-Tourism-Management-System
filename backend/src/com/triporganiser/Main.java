package com.triporganiser;

import java.util.*;

public class Main{
    private static final Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static List<Package> packages = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static User currentUser = null;
    private static int packageCounter = 1;
    private static int bookingCounter = 1;
    public static void main(String[] args){
        seedData();
        boolean running = true;
        System.out.println("=============================================");
        System.out.println("Welcome To Trip & Tourism Management System");
        System.out.println("=============================================");
        while(running){
            if(currentUser == null){
                showAuthMenu();
            }else if(currentUser instanceof Admin){
                showAdminMenu();
            }else if(currentUser instanceof Customer){
                showCustomerMenu();
            }
        }
    }
    private static void seedData(){
        users.add(new Admin(1,"Admin","admin","admin123"));
        users.add(new Customer(2,"Manoj","manoj","1234"));
        packages.add(new Package(packageCounter++,"Goa","Beach Holiday",5000,3,10));
        packages.add(new Package(packageCounter++,"Delhi","Historic Trip",4000,2,8));
    }
    private static void showAuthMenu(){
        System.out.println("\n--- Authentication Menu ---");
        System.out.println("1 . Login");
        System.out.println("2 . Exit");
        System.out.print("Enter Your Choice : ");
        int choice = readInt();

        switch(choice){
            case 1 -> handleLogin();
            case 2 -> System.exit(0);
            default -> System.out.println("Invalid Choice! Please Try Again.");
        }
    }
    private static void handleLogin(){
        System.out.print("Username : ");
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();

        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                System.out.println("✅ Login successful . Welcome , " + currentUser.getName());
                return ; 
            }
        }
        System.out.println("❌ Invalid Credentials! Please Try Again.");
    }
    private static void showAdminMenu(){
        System.out.println("\n--- Admin Menu --\n");
        System.out.println("1 . View All Packages");
        System.out.println("2 . Create New Package");
        System.out.println("3 . Update Package");
        System.out.println("4 . Delete Package");
        System.out.println("5 . Logout");
        System.out.println("Enter Your Choice : ");
        int choice =  readInt();

        switch(choice){
            case 1-> viewAllPackages();
            case 2 -> createPackage();
            case 3 -> updatePackage();
            case 4 -> deletePackage();
            case 5 -> logout();
            default -> System.out.println("Invalid Option! Please Try Again.");
        }
    }
    private static void showCustomerMenu(){
        System.out.println("\n--- Customer Menu ---\n");
        System.out.println("1 . View All Packages");
        System.out.println("2 . Book A Package");
        System.out.println("3 . View My Bookings");
        System.out.println("4 . Cancel Bookings");
        System.out.println("5 . Logout ");
        System.out.println("Enter Choice : ");
        int choice = readInt();

        switch(choice){
            case 1 -> viewAllPackages();
            case 2 -> bookPackage();
            case 3 -> viewMyBookings();
            case 4 -> cancelBooking();
            case 5 -> logout();
            default -> System.out.println("Invalid Option! Please Try Again.");
        }
    }
    private static void viewAllPackages(){
        if(packages.isEmpty()){
            System.out.println("No Packages Available.");
            return ;
        }
        packages.forEach(System.out::println);
    }
    private static void createPackage(){
        System.out.print("Destination : ");
        String dest = scanner.nextLine();
        System.out.print("Description : ");
        String desc = scanner.nextLine();
        System.out.print("Price : ");
        double price = readDouble();
        System.out.print("Duration (in Days) : ");
        int duration = readInt();
        System.out.print("Seats : ");
        int seats = readInt();

        packages.add(new Package(packageCounter++,dest,desc,price,duration,seats));
        System.out.println("✅ Package Created Successfully.");
    }
    private static void updatePackage(){
        System.out.print("Enter Package Id To Update : ");
        int id = readInt();
        for(Package p : packages){
            if(p.getPackageId() == id){
                System.out.print("Updating Package : " + p);
                System.out.print("New Destination (Leave Blank To Keep Same) : ");
                String dest = scanner.nextLine();
                if(!dest.isEmpty()){
                    p.setDestination(dest);
                }
                System.out.print("New Description (leave Blank TO Keep Same) :");
                String desc = scanner.nextLine();
                if(!desc.isEmpty()){
                    p.setDescription(desc);
                }
                System.out.println("New Price (0 To Keep Same) : ");
                double price = readDouble();
                if(price > 0){
                    p.setPrice(price);
                }
                System.out.print("New Duration (0 To keep Same) : ");
                int duration = readInt();
                if(duration > 0){
                    p.setDuration(duration);
                }
                System.out.print("New Seats (0 To Keep Same) : ");
                int seats = readInt();
                if(seats > 0){
                    p.setAvailableSeats(seats);
                }
                System.out.println("✅ package Updated Successfully.");
                return ;
            }
        }
        System.out.println("❌ Package Not Found.");
    }
    private static void deletePackage(){
        System.out.println("Enter The Package Id To Delete : ");
        int id = readInt();
        Iterator<Package> iterator = packages.iterator();
        while(iterator.hasNext()){
            Package p = iterator.next();
            if(p.getPackageId() == id){
                iterator.remove();
                bookings.removeIf(b -> b.getPackageId() == id);
                System.out.println("✅ package Deleted Succesfully.");
                return ;
            }
        }
        System.out.println("❌ Package Not Found");
    }
    private static void bookPackage(){
        System.out.print("Enter Package ID : ");
        int id = readInt();
        for(Package p : packages){
            if(p.getPackageId() == id){
                if(p.getAvailableSeats() > 0){
                    bookings.add(new Booking(bookingCounter++,currentUser.getUserId(),id));
                    p.reduceSeats();
                    System.out.println("✅ Package Booked Succesfully.");
                }else{
                    System.out.println("❌ No Seats Available.");
                }
                return ;
            }
        }
        System.out.println("❌ Package Not Found.");
    }
    private static void viewMyBookings(){
        boolean found = false;
        for(Booking b : bookings){
            if(b.getUserId() == currentUser.getUserId()){
                System.out.println(b);
                found = true;
            }
        }
        if(!found){
            System.out.println("You Have No Bookings.");
        }
    }
    private static void cancelBooking(){
        System.out.print("Enter Booking ID : ");
        int id = readInt();
        Booking toRemove = null;
        for(Booking b : bookings){
            if(b.getBookingId() == id && b.getUserId() == currentUser.getUserId()){
                toRemove =  b;
                break;
            }
        }
        if(toRemove != null){
            bookings.remove(toRemove);
            for(Package p : packages){
                if(p.getPackageId() == toRemove.getPackageId()){
                    p.increaseSeats();
                    break;
                }
            }
            System.out.println("✅ Booking Cancelled Successfully.");
        }else{
            System.out.println("❌ Booking Not Found.");
        }
    }
    private static void logout(){
        currentUser = null;
        System.out.println("You Have Been Logged Out.");
    }
    private static int readInt(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
    private static double readDouble(){
        try{
            return Double.parseDouble(scanner.nextLine());
        }catch(Exception e){
            return 0.0;
        }
    }
}