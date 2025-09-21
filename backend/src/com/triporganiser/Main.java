package com.triporganiser;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    private static List<Package> packages = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static User currentUser = null;
    private static int packageCounter = 1;
    private static int bookingCounter = 1;

    public static void main(String[] args) {
        seedData(); // initial admin & packages
        boolean running = true;

        System.out.println("=====================================");
        System.out.println("   Welcome to Trip & Tourism System  ");
        System.out.println("=====================================");

        while (running) {
            if (currentUser == null) {
                showAuthMenu();
            } else if (currentUser instanceof Admin) {
                showAdminMenu();
            } else if (currentUser instanceof Customer) {
                showCustomerMenu();
            }
        }
    }

    private static void seedData() {
        users.add(new Admin(1, "Admin", "admin", "admin123"));
        users.add(new Customer(2, "Manoj", "manoj", "1234"));

        packages.add(new Package(packageCounter++, "Goa", "Beach holiday", 5000, 3, 10));
        packages.add(new Package(packageCounter++, "Delhi", "Historic trip", 4000, 2, 8));
    }

    private static void showAuthMenu() {
        System.out.println("\n--- Authentication Menu ---");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");
        int choice = readInt();

        switch (choice) {
            case 1 -> handleLogin();
            case 2 -> System.exit(0);
            default -> System.out.println("Invalid option.");
        }
    }

    private static void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("✅ Login successful. Welcome, " + currentUser.getName());
                return;
            }
        }
        System.out.println("❌ Invalid credentials.");
    }

   private static void showAdminMenu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. View All Packages");
        System.out.println("2. Create New Package");
        System.out.println("3. Update Package");
        System.out.println("4. Delete Package");
        System.out.println("5. Logout");
        System.out.print("Enter choice: ");
        int choice = readInt();

        switch (choice) {
            case 1 -> viewAllPackages();
            case 2 -> createPackage();
            case 3 -> updatePackage();
            case 4 -> deletePackage();
            case 5 -> logout();
            default -> System.out.println("Invalid option.");
        }
}


    private static void showCustomerMenu() {
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. View Packages");
        System.out.println("2. Book a Package");
        System.out.println("3. View My Bookings");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Logout");
        System.out.print("Enter choice: ");
        int choice = readInt();

        switch (choice) {
            case 1 -> viewAllPackages();
            case 2 -> bookPackage();
            case 3 -> viewMyBookings();
            case 4 -> cancelBooking();
            case 5 -> logout();
            default -> System.out.println("Invalid option.");
        }
    }

    private static void viewAllPackages() {
        if (packages.isEmpty()) {
            System.out.println("No packages available.");
            return;
        }
        packages.forEach(System.out::println);
    }

    private static void createPackage() {
        System.out.print("Destination: ");
        String dest = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Price: ");
        double price = readDouble();
        System.out.print("Duration (days): ");
        int duration = readInt();
        System.out.print("Seats: ");
        int seats = readInt();

        packages.add(new Package(packageCounter++, dest, desc, price, duration, seats));
        System.out.println("✅ Package created.");
    }

    private static void bookPackage() {
        System.out.print("Enter Package ID: ");
        int id = readInt();
        for (Package p : packages) {
            if (p.getPackageId() == id) {
                if (p.getAvailableSeats() > 0) {
                    bookings.add(new Booking(bookingCounter++, currentUser.getUserId(), id));
                    p.reduceSeats();
                    System.out.println("✅ Booking successful.");
                } else {
                    System.out.println("❌ No seats available.");
                }
                return;
            }
        }
        System.out.println("❌ Package not found.");
    }

    private static void viewMyBookings() {
        boolean found = false;
        for (Booking b : bookings) {
            if (b.getUserId() == currentUser.getUserId()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("You have no bookings.");
    }

    private static void cancelBooking() {
        System.out.print("Enter Booking ID: ");
        int id = readInt();
        Booking toRemove = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == id && b.getUserId() == currentUser.getUserId()) {
                toRemove = b;
                break;
            }
        }
        if (toRemove != null) {
            bookings.remove(toRemove);
            for (Package p : packages) {
                if (p.getPackageId() == toRemove.getPackageId()) {
                    p.increaseSeats();
                    break;
                }
            }
            System.out.println("✅ Booking cancelled.");
        } else {
            System.out.println("❌ Booking not found.");
        }
    }

    private static void logout() {
        currentUser = null;
        System.out.println("You have been logged out.");
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    private static double readDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return 0.0;
        }
    }
}
