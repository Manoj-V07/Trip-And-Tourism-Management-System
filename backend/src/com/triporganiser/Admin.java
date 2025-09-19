package com.triporganiser;

public class Admin extends User {
    private String adminLevel;
    private String department;

    public Admin(int userId, String username, String password, String name, String email) {
        super(userId, username, password, name, email, "admin");
        this.adminLevel = "standard";
        this.department = "general";
    }

    public boolean canManageUsers() {
        return "senior".equals(adminLevel) || "super".equals(adminLevel);
    }

    public void setAdminLevel(String level) {
        if (level == null || (!level.equals("standard") && !level.equals("senior") && !level.equals("super")))
            throw new IllegalArgumentException("Invalid admin level");
        this.adminLevel = level;
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) this.department = department;
    }

    public String getAdminLevel() { return adminLevel; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", level='" + adminLevel + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
