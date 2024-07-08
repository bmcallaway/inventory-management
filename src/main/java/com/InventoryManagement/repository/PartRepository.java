package com.InventoryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.InventoryManagement.models.Part;

public interface PartRepository extends CrudRepository<Part, Integer>{
    
    Iterable<Part> findByOrders_Id(int id);
    
    @Query("SELECT p FROM Part p WHERE p.id IN :ids")
    List<Part> findByIds(@Param("ids") List<Integer> partIds);
    
    Part findById(int id);
}
