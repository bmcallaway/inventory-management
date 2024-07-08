package com.InventoryManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.InventoryManagement.models.Requisition;
import com.InventoryManagement.repository.RequisitionRepository;

@Controller
@RequestMapping("/requisitions")
public class RequisitionController {

    RequisitionRepository reqRepo;
    
    public RequisitionController(RequisitionRepository reqRepo) {
        this.reqRepo = reqRepo;
    }
    
    @GetMapping
    public String reqHomePage(Model model) {
        Iterable<Requisition> reqs = reqRepo.findAll();
        model.addAttribute("reqs", reqs);
        return "reqHome";
    }
    
    @GetMapping("/new")
    public String newRequisition(Model model) {
        return "newReq";
    }
    

}
