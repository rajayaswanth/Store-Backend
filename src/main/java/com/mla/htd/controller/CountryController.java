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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class CountryController {
	
	@Autowired
	CountryRepository countryRepo;
	
	/**
	 * Creates Country
	 * @param country
	 * @return
	 */
	@PostMapping("/country")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Country addCountry(@RequestBody Country country) {
		return countryRepo.save(country);
	}
	
	/**
	 * Updates Country
	 * @param country
	 * @return
	 */
	@PutMapping("/country")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Country updateCountry(@RequestBody Country country) {
		return countryRepo.save(country);
	}
	
	/**
	 * Gets all countries list
	 * @return
	 */
	@GetMapping("/country")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Country> getAllCountries() {
		return countryRepo.findAll();
	}
	
	/**
	 * Deletes country by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/country/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteCountry(@PathVariable Long id) {
		countryRepo.deleteById(id);
		return "Deleted Successfully";
	}

}
