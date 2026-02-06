package com.jobportal.util;

public class AdminGenerator {
    public static void main(String[] args) {

        String password = "admin@123";

        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hashPassword(password, salt);

        System.out.println("ADMIN PASSWORD: " + password);
        System.out.println("SALT = " + salt);
        System.out.println("HASH = " + hash);
    }
}