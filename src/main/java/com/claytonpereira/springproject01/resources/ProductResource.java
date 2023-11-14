package com.claytonpereira.springproject01.resources;

import com.claytonpereira.springproject01.entities.Product;
import com.claytonpereira.springproject01.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    //Injecao de dependencia do framework com @Autowired
    //@Autowired
    private final ProductService productService;

    //Injecao de dependencia por construtor
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products =  productService.findAll();
        return ResponseEntity.ok().body(products);
    }
    
    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
