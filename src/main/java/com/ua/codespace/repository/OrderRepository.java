package com.ua.codespace.repository;

import com.ua.codespace.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lesha Naumenko on 28.12.2016.
 */
public interface OrderRepository extends JpaRepository<Order, Long > {
}
