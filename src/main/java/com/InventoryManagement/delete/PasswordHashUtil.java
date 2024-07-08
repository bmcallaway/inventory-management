package com.InventoryManagement.delete;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashUtil {

    public static void main(String[] args) {
        String plaintextPassword = "password"; // replace with your actual plaintext password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(plaintextPassword);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}
