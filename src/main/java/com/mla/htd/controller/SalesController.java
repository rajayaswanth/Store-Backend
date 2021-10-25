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

@RestController
public class SalesController {
	
	@Autowired
	SalesRepository salesRepo;
	
	@PostMapping("/sales")
	Sales addSales(@RequestBody Sales sales) {
		return salesRepo.save(sales);
	}
	
	@PutMapping("/sales")
	Sales updateSales(@RequestBody Sales sales) {
		return salesRepo.save(sales);
	}
	
	@GetMapping("/sales")
	List<Sales> getAllSales() {
		return salesRepo.findAll();
	}
	
	@DeleteMapping("/sales/{id}")
	String deleteSales(@PathVariable Long id) {
		salesRepo.deleteById(id);
		return "deleted successfully";
	}

}
