package com.ua.codespace.service.impl;



import com.ua.codespace.model.Customer;
import com.ua.codespace.repository.CustomerRepository;
import com.ua.codespace.service.MyCustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lesha Naumenko on 28.11.2016.
 */
@Service
@Transactional
public class MyCustomerDAOImpl implements MyCustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
