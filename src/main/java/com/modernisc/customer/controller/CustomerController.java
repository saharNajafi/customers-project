package com.modernisc.customer.controller;

import java.util.List;

import com.modernisc.customer.exception.ResourceNotFoundException;
import com.modernisc.customer.model.Customer;
import com.modernisc.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class CustomerController
{
    @Autowired
    private CustomerService customersService;
    private List<Customer> customers;
    private Customer customer = new Customer();


    @PostConstruct
    public void init() {
        try {
            this.customers = customersService.getAllCustomers();
        } catch (ResourceNotFoundException e) {
            new ResourceNotFoundException("An exception has occurred");
        }
    }

    public void delete(Customer customer) {
        try {
            customersService.deleteCustomerById(customer.getId());
        } catch (ResourceNotFoundException e) {
            new ResourceNotFoundException("Employee not found for this id :: " + customer.getId());
        }
        customers.remove(customer);
    }


    public void add() throws ResourceNotFoundException {
        try {
            customersService.createOrUpdateCustomer(customer);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found for this id :: " + customer.getId());
        }
        this.customers = customersService.getAllCustomers();
        this.customer = new Customer();
    }

    public void update() throws ResourceNotFoundException{
        try {
            customersService.createOrUpdateCustomer(customer);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found for this id :: " + customer.getId());
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}