package com.ua.codespace.repository;

import com.ua.codespace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Lesha Naumenko on 28.12.2016.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

}
