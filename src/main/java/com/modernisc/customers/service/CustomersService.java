package com.modernisc.customers.service;

import com.modernisc.customers.model.Customers;

import java.util.List;

public interface CustomersService {

     List<Customers> getAllCustomers();
     Customers getCustomerById(Long id);
     Customers createOrUpdateCustomer(Customers entity);
     void deleteCustomerById(Long id);
}
