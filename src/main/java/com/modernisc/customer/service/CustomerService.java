package com.modernisc.customer.service;

import com.modernisc.customer.exception.ResourceNotFoundException;
import com.modernisc.customer.model.Customer;

import java.util.List;

public interface CustomerService {

     List<Customer> getAllCustomers() throws ResourceNotFoundException;
     Customer createOrUpdateCustomer(Customer customer) throws ResourceNotFoundException;
     void deleteCustomerById(Long id) throws ResourceNotFoundException;
}
