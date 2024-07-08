package com.InventoryManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.InventoryManagement.models.User;

public interface UserRepository extends CrudRepository<User, String>{
    
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.admin = true")
    User findByUsername(String username);

}
