package com.jobportal.model;

public class Application {

    private String username;   // for admin
    private String title;
    private String company;
    private String status;
    private String appliedAt;

    // ✅ Constructor for ADMIN (5 columns)
    public Application(String username, String title, String company, String status, String appliedAt) {
        this.username = username;
        this.title = title;
        this.company = company;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    // ✅ Constructor for USER (4 columns)
    public Application(String title, String company, String status, String appliedAt) {
        this.title = title;
        this.company = company;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    public String getAppliedAt() {
        return appliedAt;
    }
}