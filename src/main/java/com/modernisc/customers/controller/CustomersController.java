package com.modernisc.customers.controller;

import java.util.List;

import com.modernisc.customers.model.Customers;
import com.modernisc.customers.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Component
@ManagedBean
@ViewScoped
public class CustomersController
{
    @Autowired
    private CustomersService customersService;
    private List<Customers> customers;
    private Customers customer = new Customers();


    @PostConstruct
    public void init() {
        this.customers = customersService.getAllCustomers();
    }

    public void delete(Customers customer) {
        customersService.deleteCustomerById(customer.getId());
        customers.remove(customer);
    }


    public void add() {
        customersService.createOrUpdateCustomer(customer);
        this.customers = customersService.getAllCustomers();
        this.customer = new Customers();
    }

    public void update() {
        customersService.createOrUpdateCustomer(customer);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

}