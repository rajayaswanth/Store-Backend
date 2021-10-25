package com.mla.htd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mla.htd.entity.Customer;
import com.mla.htd.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@PostMapping("/customer")
	Customer addCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	@PutMapping("/customer")
	Customer updateCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	@GetMapping("/customer")
	List<Customer> getAllCustomersCurrencies() {
		return customerRepo.findAll();
	}
	
	@DeleteMapping("/customer/{id}")
	String deleteCustomer(@PathVariable Long id) {
		customerRepo.deleteById(id);
		return "deleted successfully";
	}

}
