package com.modernisc.customer.service;

import com.modernisc.customer.model.Customer;
import com.modernisc.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customersList = customerRepository.findAll();
        return customersList.size() > 0 ? customersList : null;
    }

    public Customer createOrUpdateCustomer(Customer customerTO) {
        Customer customer;
        customer = customerRepository.save(customerTO);
        return customer;
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
