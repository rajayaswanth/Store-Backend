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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class CountriesCurrencyController {
	
	@Autowired
	CountriesCurrencyRepository countriesCurrencyRepo;
	
	/**
	 * @param countriesCurrency
	 * Creates countriesCurrency
	 * @return countriesCurrency
	 */
	@PostMapping("/countriesCurrency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	CountriesCurrency addCountriesCurrency(@RequestBody CountriesCurrency countriesCurrency) {
		return countriesCurrencyRepo.save(countriesCurrency);
	}
	
	/**
	 * @param countriesCurrency
	 * Updates countriesCurrency
	 * @return
	 */
	@PutMapping("/countriesCurrency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	CountriesCurrency updateCountriesCurrency(@RequestBody CountriesCurrency countriesCurrency) {
		return countriesCurrencyRepo.save(countriesCurrency);
	}
	
	/**
	 * Gets all countriesCurrencies
	 * @return countriesCurrency List
	 */
	@GetMapping("/countriesCurrency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<CountriesCurrency> getAllCountriesCurrencies() {
		return countriesCurrencyRepo.findAll();
	}
	
	/**
	 * Deletes countriesCurrency by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/countriesCurrency/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteCountriesCurrency(@PathVariable Long id) {
		countriesCurrencyRepo.deleteById(id);
		return "deleted successfully";
	}

}
