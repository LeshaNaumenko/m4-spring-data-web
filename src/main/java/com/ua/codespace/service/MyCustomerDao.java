package com.ua.codespace.service;


import com.ua.codespace.model.Customer;
import com.ua.codespace.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lesha Naumenko on 28.11.2016.
 */

public interface MyCustomerDao {

    void addCustomer(Customer customer);
}
