package com.claytonpereira.springproject01.services;

import com.claytonpereira.springproject01.entities.Product;
import com.claytonpereira.springproject01.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Injecao de dependencia do framework com @Autowired
    //@Autowired
    private final ProductRepository productRepository;

    //Injecao de dependencia por construtor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
