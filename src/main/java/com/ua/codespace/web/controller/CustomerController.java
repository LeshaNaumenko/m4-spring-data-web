package com.ua.codespace.web.controller;

import com.ua.codespace.model.Customer;
import com.ua.codespace.model.Product;
import com.ua.codespace.repository.CustomerRepository;
import com.ua.codespace.repository.ProductRepository;
import com.ua.codespace.service.MyOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
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
    public String entrance(@RequestParam String login, @RequestParam String password, HttpSession session, Model model) {
        if(!login.equals("") && !password.equals("")){
            Customer customer = customerRepository.findByLoginAndPassword(login, password);
            System.out.println(customer==null);
            if (customer!=null){
                System.out.println("Привет2");
                HttpSession mySession = session;
                List<Product> products = productRepository.findAll();
                mySession.setAttribute("customer", customer);
                mySession.setAttribute("products", products);
                System.out.println("Привет3");
                return "redirect:/orders";
            }else {
                System.out.println("Привет4");
                model.addAttribute("message","such user does not exist");
                return "login";
            }
        }else {
            System.out.println("Привет5");
            model.addAttribute("message", "wrong input");
            return "login";
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
