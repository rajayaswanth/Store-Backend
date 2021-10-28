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

import com.mla.htd.entity.Product;
import com.mla.htd.repository.ProductRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	/**
	 * Creates Product
	 * @param product
	 * @return
	 */
	@PostMapping("/product")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	/**
	 * Updates Product
	 * @param product
	 * @return
	 */
	@PutMapping("/product")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	/**
	 * Gets Product List
	 * @return
	 */
	@GetMapping("/product")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	/**
	 * Deletes Product by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/product/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteProduct(@PathVariable Long id) {
		productRepo.deleteById(id);
		return "deleted successfully";
	}

}
