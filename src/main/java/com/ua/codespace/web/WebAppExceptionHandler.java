package com.ua.codespace.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ua.codespace.exception.CustomerNotFoundException;

@ControllerAdvice(basePackages = "com.ua.codespace.web")
public class WebAppExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseBody
    public String userNotFound(CustomerNotFoundException e) {
        return e.getMessage();
    }
}
