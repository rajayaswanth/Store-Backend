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

import com.mla.htd.entity.Country;
import com.mla.htd.repository.CountryRepository;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {
	
	@Mock
	CountryRepository countryRepo;
	
	@Spy
	@InjectMocks
	CountryController countryController;
	
	Country country = new Country();
	
	List<Country> countryList = new ArrayList<>();
	
	@Test
	void addCountryTest() {
		country.setName("test");
		when(countryRepo.save(Mockito.any())).thenReturn(country);
		Country response = countryController.addCountry(country);
		assertEquals("test", response.getName());
	}
	
	@Test
	void updateCountryTest() {
		country.setName("test");
		when(countryRepo.save(Mockito.any())).thenReturn(country);
		Country response = countryController.updateCountry(country);
		assertEquals("test", response.getName());
	}
	
	@Test
	void getCountryTest() {
		country.setName("test");
		countryList.add(country);
		when(countryRepo.findAll()).thenReturn(countryList);
		List<Country> response = countryController.getAllCountries();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteCountryTest() {
		doNothing().when(countryRepo).deleteById(Mockito.anyLong());
		String response = countryController.deleteCountry(1L);
		assertEquals("Deleted Successfully", response);
	}

}
