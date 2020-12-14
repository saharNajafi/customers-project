package com.modernisc.customer;

import com.modernisc.customer.exception.ResourceNotFoundException;
import com.modernisc.customer.model.Customer;
import com.modernisc.customer.repository.CustomerRepository;
import com.modernisc.customer.service.CustomerService;
import com.modernisc.customer.service.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @Spy
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    Customer customer;

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Lokesh");
        customer.setLastName("Gupta");
        customer.setEmail("abc@gmail.com");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findAll());
    }

    @Test
    public void createOrUpdateCustomer(){

        // Arrange
        when(customerRepository.save(customer)).thenReturn(customer);
        // Act
        Customer savedCustomer = customerService.createOrUpdateCustomer(customer);
        // Assert
        assertEquals(savedCustomer, customer);
    }

    @Test
    public void deleteCustomerById() {
        doNothing().when(customerRepository).deleteById(5L);
        customerService.deleteCustomerById(5L);
        verify(customerRepository, times(1)).deleteById(5L);
    }

 /*   @Test
    public void getCustomerById() throws Exception {
        Mockito.doReturn(customer).when(customerService).getCustomerById(5);
        Product retrievedCustomer = customerService.getCustomerById(5);
        Mockito.verify(customerService).getCustomerById(5);
    }*/

//    @Test
//    public void getAllCustomers() throws Exception {
//        Page<Customer> customers = Mockito.mock(Page.class);
//        Mockito.when(this.customerRepository.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn(customers);
//        verify(customerRepository).findAll();
//    }
}