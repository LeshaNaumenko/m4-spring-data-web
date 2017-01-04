package com.ua.codespace.web.controller;

import com.ua.codespace.model.Customer;
import com.ua.codespace.model.Product;
import com.ua.codespace.repository.CustomerRepository;
import com.ua.codespace.repository.ProductRepository;
import com.ua.codespace.service.MyCustomerDao;
import com.ua.codespace.service.MyOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"customer", "products","orderId"})
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MyCustomerDao myCustomerDao;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MyOrderDao myOrderDao;

    @RequestMapping(method = RequestMethod.GET)
    public String getSingIn() {
        return "login";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String sign_in() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(Customer customer) {
        myCustomerDao.addCustomer(customer);
        return "redirect:/";
    }

    @RequestMapping(value = "/entrance", method = RequestMethod.POST)
    public ModelAndView entrance(@RequestParam String login, @RequestParam String password, Model model) {
        if (!login.equals("") && !password.equals("")) {
            Customer customer = customerRepository.findByLoginAndPassword(login, password);
            if (customer != null) {
                return new ModelAndView("redirect:/orders2", "customer", customer);
            } else {
                return new ModelAndView("login", "message", "such user does not exist");
            }
        } else {
            return new ModelAndView("login", "message", "wrong input");
        }
    }

    @RequestMapping(value = "/orders2", method = RequestMethod.GET)
    public ModelAndView orders2(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView();

        if(customer.getFirstName()==null){
            System.out.println("сессии нету ");
            modelAndView.addObject("existSession", 0);
        }else{
            System.out.println("Есть сессия ");
            modelAndView.addObject("existSession", 1);
        }
        List<Product> products = productRepository.findAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("orders");
        return modelAndView;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public ModelAndView checkout(@ModelAttribute Customer customer, @RequestParam("favoriteProduct") List<Long> favorite) {
        Long orderId = myOrderDao.checkOut(customer, favorite);
        return new ModelAndView("redirect:/success", "orderId", orderId);
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/leave_the_session")
    public String leaveTheSession(SessionStatus status) {
        System.out.println("Clean Session...");
        status.setComplete();
        System.out.println("Clean "+ status.toString());
        return "login";
    }
    @ModelAttribute
    public Customer createCustomer(){
        return new Customer();
    }
}
