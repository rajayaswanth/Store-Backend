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

import com.mla.htd.entity.Currency;
import com.mla.htd.repository.CurrencyRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyRepository currencyRepo;
	
	/**
	 * Creates Currency
	 * @param currency
	 * @return
	 */
	@PostMapping("/currency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Currency addCurrency(@RequestBody Currency currency) {
		return currencyRepo.save(currency);
	}
	
	/**
	 * Updates Currency
	 * @param currency
	 * @return
	 */
	@PutMapping("/currency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Currency updateCurrency(@RequestBody Currency currency) {
		return currencyRepo.save(currency);
	}
	
	/**
	 * Gets Currency List
	 * @return
	 */
	@GetMapping("/currency")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Currency> getAllCurrencies() {
		return currencyRepo.findAll();
	}
	
	/**
	 * Deletes currecy by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/currency/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteCurrency(@PathVariable Long id) {
		currencyRepo.deleteById(id);
		return "deleted successfully";
	}

}
