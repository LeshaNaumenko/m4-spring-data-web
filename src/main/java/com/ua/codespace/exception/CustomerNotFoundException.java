package com.ua.codespace.exception;

public class CustomerNotFoundException extends RuntimeException {
    private String username;

    public CustomerNotFoundException(Long id) {
        super("Customer not found! [id=" + id + "]");
        this.username = username;
    }
}
