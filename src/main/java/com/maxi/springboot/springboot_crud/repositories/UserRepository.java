package com.maxi.springboot.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.maxi.springboot.springboot_crud.entities.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long>{

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
