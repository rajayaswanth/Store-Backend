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

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("/product")
	Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@PutMapping("/product")
	Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	@GetMapping("/product")
	List<Product> getAllProductsCurrencies() {
		return productRepo.findAll();
	}
	
	@DeleteMapping("/product/{id}")
	String deleteProduct(@PathVariable Long id) {
		productRepo.deleteById(id);
		return "deleted successfully";
	}

}
