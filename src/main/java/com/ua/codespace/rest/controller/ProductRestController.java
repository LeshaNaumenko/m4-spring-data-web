package com.ua.codespace.rest.controller;

import com.ua.codespace.model.Product;
import com.ua.codespace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lesha Naumenko on 04.01.2017.
 */
@RestController
@RequestMapping("/rest")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping
    public Page<Product> getProducts(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

    @RequestMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Product product = productRepository.findOne(id);
        return product;
    }
}
