package com.maxi.springboot.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxi.springboot.springboot_crud.entities.Product;
import com.maxi.springboot.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        // TODO Auto-generated method stub
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        // TODO Auto-generated method stub
        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {
        
        Optional<Product> productOptional = repository.findById(id);
        
        if(productOptional.isPresent()){
            Product productDb = productOptional.orElseThrow();

            productDb.setName(product.getName());
            productDb.setDescripcion(product.getDescripcion());
            productDb.setPrice(product.getPrice());
            return Optional.of(repository.save(productDb));
        }

        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        // TODO Auto-generated method stub
        Optional<Product> productOptional = repository.findById(id);
        productOptional.ifPresent(productDb -> {
            repository.delete(productDb);
        });

        return productOptional;
    }

}
