package com.maxi.springboot.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.maxi.springboot.springboot_crud.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{


    

}
