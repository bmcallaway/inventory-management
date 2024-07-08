package com.InventoryManagement.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Part {
    @Id
    int id;
    
    @ManyToMany(mappedBy="parts")
    List<CustomerOrder> orders;
    
    String description;
    long price;
    
    @ManyToOne
    Vendor vendor;
    
    boolean stockItem;
    int count;
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public long getPrice() {
        return price;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public boolean isStockItem() {
        return stockItem;
    }

    public void setStockItem(boolean stockItem) {
        this.stockItem = stockItem;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
