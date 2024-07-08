package com.InventoryManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.models.Part;
import com.InventoryManagement.repository.PartRepository;
import com.InventoryManagement.services.PartService;

@Controller
@RequestMapping("/parts")
public class PartController {

    PartRepository partRepository;
    PartService partService;
    public PartController(PartRepository partRepo, PartService partService) {
        partRepository = partRepo;
        this.partService = partService;
    }
    
    @GetMapping
    public String getAllParts(Model model){
        Iterable<Part> allParts = partRepository.findAll();
        model.addAttribute("parts", allParts);
        return "parts";
        
    }
    
    @GetMapping("/new")
    public String addPartPage(Model model) {
        model.addAttribute("part", new Part());
        return "newPart";
    }
    
    @PostMapping("/add")
    public String addPart(Part part) {
        System.out.println("Part: " + part.getDescription());
        System.out.println("Part#: " + part.getId());
        partRepository.save(part);
        return "redirect:/parts";
    }
    
    @PostMapping("/addToOrder")
    public String addPartsToOrder(@RequestParam("orderId") int orderId, @RequestParam("partIds") List<Integer> partIds) {
        partService.addPartsToOrder(orderId, partIds);
        return "redirect:/parts";
    }
    
    @GetMapping("/testPost")
    public String testPost() {
        System.out.println("New test");
        return "redirect:/parts";
    }
}
