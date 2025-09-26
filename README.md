# Trip & Tourism Management System

## Project Overview
The **Trip & Tourism Management System** is a modular, scalable Java application designed to manage travel bookings, users, and packages efficiently. It provides a clear separation of concerns between the **backend logic**, **database operations**, and **user interface**, making it suitable for both small-scale and enterprise-level applications.  

This system follows **OOP principles** like encapsulation, inheritance, and polymorphism, ensuring maintainability, scalability, and readability.

---

## Features
- **User Management**
  - Register as a Customer or Admin
  - Secure authentication with password hashing
  - Role-based access control (Admin vs Customer)
- **Booking Management**
  - Book and cancel packages
  - Track active bookings for customers
  - Admin can view all bookings
- **Package Management**
  - Admin can create, update, and deactivate travel packages
  - Customers can view active packages with available seats
- **Utilities & Validation**
  - Input validation for email, username, and password
  - Date formatting and helper functions
- **Database Connectivity**
  - MySQL integration for persistent data storage
  - Connection pooling and management
- **Exception Handling**
  - Centralized custom exception handling (`TripOrganizerException`)
- **Logging & Caching**
  - Application logging for key events
  - In-memory caching for optimized performance

---

## Tech Stack
- **Language:** Java 17+  
- **Database:** MySQL 8+  
- **Build Tool:** Maven  
- **IDE:** IntelliJ IDEA / Eclipse  
- **Libraries:** JDBC (for database connectivity), Java Standard Library  

---

## Project Structure
backend/src/com/triporganiser

Admin.java , Booking.java , Customer.java , DBConnection.java , Main.java , Package.java , User.java .

database 

schema.sql


<img width="633" height="917" alt="image" src="https://github.com/user-attachments/assets/4c859c82-5577-4eef-af13-1a955902275c" />


