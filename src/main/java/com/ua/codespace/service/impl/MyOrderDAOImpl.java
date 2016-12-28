package com.ua.codespace.service.impl;


import com.ua.codespace.model.Customer;
import com.ua.codespace.model.Order;
import com.ua.codespace.model.Product;
import com.ua.codespace.repository.OrderRepository;
import com.ua.codespace.repository.ProductRepository;
import com.ua.codespace.service.MyOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lesha Naumenko on 02.12.2016.
 */
@Component
@Transactional
public class MyOrderDAOImpl implements MyOrderDao {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Long checkOut(Customer c, List<Long> listId) {
        System.out.println("Hello");
        Order custOrder = new Order(c);
        List<Product> list = new ArrayList<>();
        for (Long aLong : listId) {
            list.add(productRepository.findOne(aLong));
        }
        custOrder.addProductsList(list);
        orderRepository.saveAndFlush(custOrder);
        return custOrder.getId();
    }
}
