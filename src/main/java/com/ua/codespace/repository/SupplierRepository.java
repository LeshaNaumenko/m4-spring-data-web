package com.ua.codespace.repository;

import com.ua.codespace.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
