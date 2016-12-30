package com.ua.codespace.repository;

import com.ua.codespace.model.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Lesha Naumenko on 25.12.2016.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLoginAndPassword(String login, String password);
//
//    Customer findByLogin(String login);
//
//    Customer findByEmail(String email);



}
