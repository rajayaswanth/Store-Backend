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

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyRepository currencyRepo;
	
	@PostMapping("/currency")
	Currency addCurrency(@RequestBody Currency currency) {
		return currencyRepo.save(currency);
	}
	
	@PutMapping("/currency")
	Currency updateCurrency(@RequestBody Currency currency) {
		return currencyRepo.save(currency);
	}
	
	@GetMapping("/currency")
	List<Currency> getAllCurrencies() {
		return currencyRepo.findAll();
	}
	
	@DeleteMapping("/currency/{id}")
	String deleteCurrency(@PathVariable Long id) {
		currencyRepo.deleteById(id);
		return "deleted successfully";
	}

}
