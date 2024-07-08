package com.InventoryManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InventoryManagement.models.CustomerOrder;
import com.InventoryManagement.models.Part;
import com.InventoryManagement.repository.CustomerOrderRepository;
import com.InventoryManagement.repository.PartRepository;

@Service
public class PartService {
    
    PartRepository partRepo;
    CustomerOrderRepository orderRepo;
    
    public PartService(PartRepository partRepo, CustomerOrderRepository orderRepo) {
        this.partRepo = partRepo;
        this.orderRepo = orderRepo;
    }
    
    public Iterable<Part> findPartsForOrder(CustomerOrder order) {
        return partRepo.findByOrders_Id(order.getId());
    }
    
    public void addPartsToOrder(int orderId, List<Integer> partIds) {
        CustomerOrder order = orderRepo.findById(orderId);
        System.out.println("Order: " + order.getId());
        
        List<Part> parts = partRepo.findByIds(partIds);
        
        System.out.println("Parts: ");
        for(Part p: parts) {
            System.out.println("Part- " + p.getDescription());
        }
        System.out.println("End of parts");
        
        order.addParts(parts);
        
        System.out.println("Parts added to order");
        
        orderRepo.save(order);
        
        System.out.println("Order Repo Saved");
    }
}
