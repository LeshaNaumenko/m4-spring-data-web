package com.ua.codespace.rest.controller;

import com.ua.codespace.exception.UserNotFoundException;
import com.ua.codespace.model.Customer;
import com.ua.codespace.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getUsers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        Customer user = customerRepository.findOne(id);
        if (user==null){
            throw new UserNotFoundException(id);
        }else {
            return user;
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
