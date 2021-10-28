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

import com.mla.htd.entity.Sales;
import com.mla.htd.repository.SalesRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class SalesController {
	
	@Autowired
	SalesRepository salesRepo;
	
	/**
	 * Creates Sales
	 * @param sales
	 * @return
	 */
	@PostMapping("/sales")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Sales addSales(@RequestBody Sales sales) {
		return salesRepo.save(sales);
	}
	
	/**
	 * Update Sales
	 * @param sales
	 * @return
	 */
	@PutMapping("/sales")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Sales updateSales(@RequestBody Sales sales) {
		return salesRepo.save(sales);
	}
	
	/**
	 * Gets sales list
	 * @return
	 */
	@GetMapping(value = "/sales")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Sales> getAllSales() {
		return salesRepo.findAll();
	}
	
	/**
	 * Delete sales by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/sales/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteSales(@PathVariable Long id) {
		salesRepo.deleteById(id);
		return "deleted successfully";
	}

}
