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

import com.mla.htd.entity.Sales;
import com.mla.htd.repository.SalesRepository;

@ExtendWith(MockitoExtension.class)
public class SalesControllerTest {
	
	@Mock
	SalesRepository salesReo;
	
	@Spy
	@InjectMocks
	SalesController salesController;
	
	Sales sales = new Sales();
	
	List<Sales> salesList = new ArrayList<>();
	
	@Test
	void addSalesTest() {
		sales.setSalesChannel("test");
		when(salesReo.save(Mockito.any())).thenReturn(sales);
		Sales response = salesController.addSales(sales);
		assertEquals("test", response.getSalesChannel());
	}
	
	@Test
	void updateSalesTest() {
		sales.setSalesChannel("test");
		when(salesReo.save(Mockito.any())).thenReturn(sales);
		Sales response = salesController.updateSales(sales);
		assertEquals("test", response.getSalesChannel());
	}
	
	@Test
	void getSalesTest() {
		sales.setSalesChannel("test");
		salesList.add(sales);
		when(salesReo.findAll()).thenReturn(salesList);
		List<Sales> response = salesController.getAllSales();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteSalesTest() {
		doNothing().when(salesReo).deleteById(Mockito.anyLong());
		String response = salesController.deleteSales(1L);
		assertEquals("deleted successfully", response);
	}

}
