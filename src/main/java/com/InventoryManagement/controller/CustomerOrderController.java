package com.InventoryManagement.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.InventoryManagement.models.CustomerOrder;
import com.InventoryManagement.models.Part;
import com.InventoryManagement.repository.CustomerOrderRepository;
import com.InventoryManagement.services.CustomerOrderService;
import com.InventoryManagement.services.PartService;

@Controller
@RequestMapping("/orders")
public class CustomerOrderController {

    
    CustomerOrderService orderService;
    PartService partService;
    
    public CustomerOrderController(CustomerOrderService orderService, PartService partService) {
        this.orderService = orderService;
        this.partService = partService;
    }
    
    @GetMapping
    public String getOrders(
            @RequestParam(name = "status", required = false)String status, 
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "insurance", required = false) String insurance,
            @RequestParam(name = "date", required = false) String date,
            Model model) {
        
        LinkedList<String> filters = new LinkedList<String>();
        filters.add(status);
        filters.add(firstName);
        filters.add(lastName);
        filters.add(insurance);
        filters.add(date);
        
        
        
        Iterable<CustomerOrder> orders = orderService.findByFilters(filters);
       
        model.addAttribute("orders", orders);
        return "orders";
    }
    
    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") int orderId, Model model) {
        CustomerOrder order = orderService.findOrder(orderId);
        
        Iterable<Part> orderParts = partService.findPartsForOrder(order);

        model.addAttribute("order", order);
        model.addAttribute("parts", orderParts);
        return "order.html";
    }
    
    
}
