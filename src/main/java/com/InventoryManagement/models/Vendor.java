package com.InventoryManagement.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vendor {

    @Id
    char[] code = new char[3];
    
    String name;
    
    @OneToMany
    List<Part> partsForSale;

    public char[] getVendorCode() {
        return code;
    }

    public void setVendorCode(char[] vendorCode) {
        this.code = vendorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getPartsForSale() {
        return partsForSale;
    }

    public void setPartsForSale(List<Part> partsForSale) {
        this.partsForSale = partsForSale;
    }
    
    
}
