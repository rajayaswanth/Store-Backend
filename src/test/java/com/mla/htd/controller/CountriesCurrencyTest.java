package com.mla.htd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mla.htd.entity.CountriesCurrency;
import com.mla.htd.entity.Country;
import com.mla.htd.repository.CountriesCurrencyRepository;

@ExtendWith(MockitoExtension.class)
public class CountriesCurrencyTest {
	
	@Mock
	CountriesCurrencyRepository countriesCurrencyRepo;
	
	@Spy
	@InjectMocks
	CountriesCurrencyController countriesCurrencyController;
	
	CountriesCurrency countriesCurrency = new CountriesCurrency();
	
	List<CountriesCurrency> countriesCurrencyList = new ArrayList<>();
	
	Country country = new Country();
	
	@Test
	void addCountryTest() {
		country.setName("test");
		countriesCurrency.setCounty(country);
		when(countriesCurrencyRepo.save(Mockito.any())).thenReturn(countriesCurrency);
		CountriesCurrency response = countriesCurrencyController.addCountriesCurrency(countriesCurrency);
		assertEquals("test", response.getCounty().getName());
	}
	
	@Test
	void updateCountryTest() {
		country.setName("test");
		countriesCurrency.setCounty(country);
		when(countriesCurrencyRepo.save(Mockito.any())).thenReturn(countriesCurrency);
		CountriesCurrency response = countriesCurrencyController.updateCountriesCurrency(countriesCurrency);
		assertEquals("test", response.getCounty().getName());
	}
	
	@Test
	void getCountryTest() {
		country.setName("test");
		countriesCurrency.setCounty(country);
		countriesCurrencyList.add(countriesCurrency);
		when(countriesCurrencyRepo.findAll()).thenReturn(countriesCurrencyList);
		List<CountriesCurrency> response = countriesCurrencyController.getAllCountriesCurrencies();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteCountryTest() {
		doNothing().when(countriesCurrencyRepo).deleteById(Mockito.anyLong());
		String response = countriesCurrencyController.deleteCountriesCurrency(1L);
		assertEquals("deleted successfully", response);
	}

}
