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

import com.mla.htd.entity.CountriesCurrency;
import com.mla.htd.repository.CountriesCurrencyRepository;

@RestController
public class CountriesCurrencyController {
	
	@Autowired
	CountriesCurrencyRepository countriesCurrencyRepo;
	
	@PostMapping("/countriesCurrency")
	CountriesCurrency addCountriesCurrency(@RequestBody CountriesCurrency countriesCurrency) {
		return countriesCurrencyRepo.save(countriesCurrency);
	}
	
	@PutMapping("/countriesCurrency")
	CountriesCurrency updateCountriesCurrency(@RequestBody CountriesCurrency countriesCurrency) {
		return countriesCurrencyRepo.save(countriesCurrency);
	}
	
	@GetMapping("/countriesCurrency")
	List<CountriesCurrency> getAllCountriesCurrencies() {
		return countriesCurrencyRepo.findAll();
	}
	
	@DeleteMapping("/countriesCurrency/{id}")
	String deleteCountriesCurrency(@PathVariable Long id) {
		countriesCurrencyRepo.deleteById(id);
		return "deleted successfully";
	}

}
