package com.ua.codespace.service;


import com.ua.codespace.model.Customer;

import java.util.List;

/**
 * Created by Lesha Naumenko on 02.12.2016.
 */
public interface MyOrderDao {

    Long checkOut(Customer c, List<Long> listId);
}
