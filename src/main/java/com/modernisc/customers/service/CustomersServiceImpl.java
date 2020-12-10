package com.modernisc.customers.service;

import com.modernisc.customers.model.Customers;
import com.modernisc.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customers> getAllCustomers() {
        List<Customers> customersList = customerRepository.findAll();
        return  customersList.size() > 0 ? customersList : null;
    }

    public Customers getCustomerById(Long id) {
        Optional<Customers> customer = customerRepository.findById(id);
            return customer.get();
    }

    public Customers createOrUpdateCustomer(Customers entity)  {
     return customerRepository.saveAndFlush(entity);
    }

    public void deleteCustomerById(Long id) {
            customerRepository.deleteById(id);
    }

}
