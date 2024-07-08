package com.InventoryManagement.repository;

import com.InventoryManagement.models.CustomerOrder;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Integer>{
    
    List<CustomerOrder> findByStatus(String status);
    
    List<CustomerOrder> findAll();


    @Query("SELECT co FROM CustomerOrder co " +
            "WHERE (co.status = COALESCE(:status, co.status) OR :status is null or :status = '') " +
            "AND (co.firstName = COALESCE(:firstName, co.firstName) OR :firstName is null or :firstName = '') " +
            "AND (co.lastName = COALESCE(:lastName, co.lastName) OR :lastName is null or :lastName = '') " +
            "AND (co.insurance = COALESCE(:insurance, co.insurance) OR :insurance is null or :insurance = '') " +
            "AND (co.date = COALESCE(:date, co.date) OR :date is null or :date = '')")
     List<CustomerOrder> findByFilters(@Param("status") String status,
                                       @Param("firstName") String firstName,
                                       @Param("lastName") String lastName,
                                       @Param("insurance") String insurance,
                                       @Param("date") String date);

    CustomerOrder findById(int id);
}
