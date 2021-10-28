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

import com.mla.htd.entity.Region;
import com.mla.htd.repository.RegionRepository;

@ExtendWith(MockitoExtension.class)
public class RegionControllerTest {
	
	@Mock
	RegionRepository regionRepo;
	
	@Spy
	@InjectMocks
	RegionController regionController;
	
	Region region = new Region();
	
	List<Region> regionList = new ArrayList<>();
	
	@Test
	void addRegionTest() {
		region.setName("test");
		when(regionRepo.save(Mockito.any())).thenReturn(region);
		Region response = regionController.addRegion(region);
		assertEquals("test", response.getName());
	}
	
	@Test
	void updateRegionTest() {
		region.setName("test");
		when(regionRepo.save(Mockito.any())).thenReturn(region);
		Region response = regionController.updateRegion(region);
		assertEquals("test", response.getName());
	}
	
	@Test
	void getRegionTest() {
		region.setName("test");
		regionList.add(region);
		when(regionRepo.findAll()).thenReturn(regionList);
		List<Region> response = regionController.getAllRegions();
		assertEquals(1, response.size());
	}
	
	@Test
	void deleteSalesTest() {
		doNothing().when(regionRepo).deleteById(Mockito.anyLong());
		String response = regionController.deleteRegion(1L);
		assertEquals("deleted successfully", response);
	}

}
