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

import com.mla.htd.entity.Currency;
import com.mla.htd.repository.CurrencyRepository;

@ExtendWith(MockitoExtension.class)
public class CurrencyControllerTest {
	
	@Mock
	CurrencyRepository currencyRepo;
	
	@Spy
	@InjectMocks
	CurrencyController currencyController;
	
	Currency currency = new Currency();
	
	List<Currency> currencyList = new ArrayList<>();
	
	@Test
	void addCurrencyTest() {
		currency.setName("test");
		when(currencyRepo.save(Mockito.any())).thenReturn(currency);
		Currency response = currencyController.addCurrency(currency);
		assertEquals("test", response.getName());
	}
	
	@Test
	void updateCurrencyTest() {
		currency.setName("test");
		when(currencyRepo.save(Mockito.any())).thenReturn(currency);
		Currency response = currencyController.updateCurrency(currency);
		assertEquals("test", response.getName());
	}
	
	@Test
	void getCurrencyTest() {
		currency.setName("test");
		currencyList.add(currency);
		when(currencyRepo.findAll()).thenReturn(currencyList);
		List<Currency> response = currencyController.getAllCurrencies();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteCurrencyTest() {
		doNothing().when(currencyRepo).deleteById(Mockito.anyLong());
		String response = currencyController.deleteCurrency(1L);
		assertEquals("deleted successfully", response);
	}

}
