package com.triporganiser;

import java.util.Objects;

public class User {
    protected int userId;
    protected String username;
    protected String password;
    protected String name;
    protected String email;
    protected String userType;

    public User(int userId, String username, String password, String name, String email, String userType) {
        this.userId = userId;
        setUsername(username);
        setPassword(password);
        setName(name);
        setEmail(email);
        this.userType = userType;
    }

    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getUserType() { return userType; }

    // Setters with validation
    public void setUsername(String username) {
        if (username == null || username.trim().length() < 3)
            throw new IllegalArgumentException("Username must be at least 3 characters");
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("Password must be at least 6 characters");
        this.password = password;
    }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new IllegalArgumentException("Invalid email format");
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
