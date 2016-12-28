package com.ua.codespace.web.controller;

import com.ua.codespace.model.Customer;
import com.ua.codespace.model.Product;
import com.ua.codespace.repository.CustomerRepository;
import com.ua.codespace.repository.ProductRepository;
import com.ua.codespace.service.MyOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/", "/welcome"})
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MyOrderDao myOrderDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getSingIn() {
        return "SpringSingIn";
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.POST)
    public String entrance(@RequestParam String firstName,
                           HttpSession session) {

        if (!firstName.equals("")) {
            Customer customer = customerRepository.findByFirstName(firstName);
            if (customer == null || !customer.getFirstName().equals(firstName)) {
                return "/";
            } else {
                HttpSession session1 = session;
                List<Product> products = productRepository.findAll();
                session1.setAttribute("customer", customer);
                session1.setAttribute("products", products);
                return "redirect:/orders";
            }
        } else {
            return "/";
        }

    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(@RequestParam("favoriteProduct") List<Long> favorite, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        Long orderId = myOrderDao.checkOut(customer, favorite);
        session.setAttribute("orderId", orderId);
        return "redirect:/success";
    }
}
