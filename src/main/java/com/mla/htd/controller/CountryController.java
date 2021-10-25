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

import com.mla.htd.entity.Country;
import com.mla.htd.repository.CountryRepository;

@RestController
public class CountryController {
	
	@Autowired
	CountryRepository countryRepo;
	
	@PostMapping("/country")
	Country addCountry(@RequestBody Country country) {
		return countryRepo.save(country);
	}
	
	@PutMapping("/country")
	Country updateCountry(@RequestBody Country country) {
		return countryRepo.save(country);
	}
	
	@GetMapping("/country")
	List<Country> getAllCountries() {
		return countryRepo.findAll();
	}
	
	@DeleteMapping("/country/{id}")
	String deleteCountry(@PathVariable Long id) {
		countryRepo.deleteById(id);
		return "Deleted Successfully";
	}

}
