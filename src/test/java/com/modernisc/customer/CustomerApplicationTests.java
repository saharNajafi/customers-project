package com.modernisc.customer;


import com.modernisc.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = CustomerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllCustomers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/customers",
				HttpMethod.GET, entity, String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testGetCustomerById() {
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customers/1", Customer.class);
		System.out.println(customer.getFirstName());
		assertNotNull(customer);
	}

	@Test
	public void testCreatecustomer() {
		Customer customer = new Customer();
		customer.setEmail("admin@gmail.com");
		customer.setFirstName("admin");
		customer.setLastName("admin");

		ResponseEntity<Customer> postResponse = restTemplate.postForEntity(getRootUrl() + "/customers", customer, Customer.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateCustomer() {
		int id = 1;
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customeres/" + id, Customer.class);
		customer.setFirstName("admin1");
		customer.setLastName("admin2");

		restTemplate.put(getRootUrl() + "/customers/" + id, customer);

		Customer updatedCustomer = restTemplate.getForObject(getRootUrl() + "/customers/" + id, Customer.class);
		assertNotNull(updatedCustomer);
	}

	@Test
	public void testDeleteCustomer() {
		int id = 2;
		Customer customer = restTemplate.getForObject(getRootUrl() + "/customers/" + id, Customer.class);
		assertNotNull(customer);

		restTemplate.delete(getRootUrl() + "/customers/" + id);

		try {
			customer = restTemplate.getForObject(getRootUrl() + "/customers/" + id, Customer.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
