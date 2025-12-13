package com.maxi.springboot.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maxi.springboot.springboot_crud.entities.Role;
import java.util.List;
import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Long>{

    
    Optional<Role> findByName(String name); 

}
