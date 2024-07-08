package com.InventoryManagement.services;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.InventoryManagement.models.CustomerOrder;
import com.InventoryManagement.models.Part;
import com.InventoryManagement.repository.CustomerOrderRepository;
import com.InventoryManagement.repository.PartRepository;

@Service
public class CustomerOrderService {

    CustomerOrderRepository orderRepo;
    
    PartRepository partRepo;
    
    CustomerOrderService(CustomerOrderRepository orderRepo, PartRepository partRepo){
        this.orderRepo = orderRepo;
        this.partRepo = partRepo;
    }
    
    public void addPartToOrder(int orderId, int partId) {
        CustomerOrder custOrder = orderRepo.findById(orderId);
        Part part = partRepo.findById(partId);
        
        custOrder.addPart(part);
        orderRepo.save(custOrder);
    }
    
    Iterable<CustomerOrder> filterOrders(Iterable<String> filters, Iterable<CustomerOrder> orders){
        
        for(String s: filters) {
            switch(s) {
            case("firstName"):
                orders = filterByFirstName(orders);
                break;
            case("lastName"):
                orders = filterByLastName(orders);
                break;
            }
        }
        
        return null;
        
    }
    
    Iterable<CustomerOrder> filterByFirstName(Iterable<CustomerOrder> toFilter){
        return null;
        
    }
    
    Iterable<CustomerOrder> filterByLastName(Iterable<CustomerOrder> toFilter){
        return null;
        
    }

    public Iterable<CustomerOrder> findByFilters(LinkedList<String> filters) {
        for(String s : filters) {
            if(s == null) {
                System.out.println("s is null");
            }else if(s.isEmpty()) {
                System.out.println("s is blank");
                s = null;
            }else {
                System.out.println("S: " + s);
            }
        }
        return orderRepo.findByFilters(filters.get(0), filters.get(1), filters.get(2), filters.get(3), filters.get(4));
    }

    public CustomerOrder findOrder(int orderId) {
        return orderRepo.findById(orderId);
    }
}
