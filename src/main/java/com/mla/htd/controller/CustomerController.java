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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	/**
	 * Creates Customer
	 * @param customer
	 * @return
	 */
	@PostMapping("/customer")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Customer addCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	/**
	 * Updates Customer
	 * @param customer
	 * @return
	 */
	@PutMapping("/customer")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Customer updateCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
	/**
	 * Gets Customer List
	 * @return
	 */
	@GetMapping("/customer")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
	
	/**
	 * Deletes customer by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/customer/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteCustomer(@PathVariable Long id) {
		customerRepo.deleteById(id);
		return "deleted successfully";
	}

}
