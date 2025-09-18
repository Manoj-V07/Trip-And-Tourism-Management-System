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


Version Control: GitHub for code and documentation management
<img width="1210" height="822" alt="Screenshot 2025-08-26 123101" src="https://github.com/user-attachments/assets/ef909568-0a40-4c99-b22c-7a5225c4d444" />

