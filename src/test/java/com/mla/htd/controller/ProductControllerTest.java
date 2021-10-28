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

import com.mla.htd.entity.Product;
import com.mla.htd.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	@Mock
	ProductRepository productRepo;
	
	@Spy
	@InjectMocks
	ProductController productController;
	
	Product product = new Product();
	
	List<Product> productList = new ArrayList<>();
	
	@Test
	void addProductTest() {
		product.setName("test");
		when(productRepo.save(Mockito.any())).thenReturn(product);
		Product response = productController.addProduct(product);
		assertEquals("test", response.getName());
	}
	
	@Test
	void updateProductTest() {
		product.setName("test");
		when(productRepo.save(Mockito.any())).thenReturn(product);
		Product response = productController.updateProduct(product);
		assertEquals("test", response.getName());
	}
	
	@Test
	void getProductTest() {
		product.setName("test");
		productList.add(product);
		when(productRepo.findAll()).thenReturn(productList);
		List<Product> response = productController.getAllProducts();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteProductTest() {
		doNothing().when(productRepo).deleteById(Mockito.anyLong());
		String response = productController.deleteProduct(1L);
		assertEquals("deleted successfully", response);
	}

}
