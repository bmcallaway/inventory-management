package com.InventoryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id
    String username;
    String password;
    boolean admin;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdmin() {
       return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
    
}
