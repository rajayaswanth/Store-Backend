package com.mla.htd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mla.htd.entity.Customer;
import com.mla.htd.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	@Mock
	CustomerRepository customerRepo;
	
	@Spy
	@InjectMocks
	CustomerController customerController;
	
	Customer customer = new Customer();
	
	List<Customer> customerList = new ArrayList<>();
	
	@Test
	void addCustomerTest() {
		customer.setFirstName("test");
		when(customerRepo.save(Mockito.any())).thenReturn(customer);
		Customer response = customerController.addCustomer(customer);
		assertEquals("test", response.getFirstName());
	}
	
	@Test
	void updateCustomerTest() {
		customer.setFirstName("test");
		when(customerRepo.save(Mockito.any())).thenReturn(customer);
		Customer response = customerController.updateCustomer(customer);
		assertEquals("test", response.getFirstName());
	}
	
	@Test
	void getCustomerTest() {
		customer.setFirstName("test");
		customerList.add(customer);
		when(customerRepo.findAll()).thenReturn(customerList);
		List<Customer> response = customerController.getAllCustomers();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteCustomerTest() {
		doNothing().when(customerRepo).deleteById(Mockito.anyLong());
		String response = customerController.deleteCustomer(1L);
		assertEquals("deleted successfully", response);
	}

}
