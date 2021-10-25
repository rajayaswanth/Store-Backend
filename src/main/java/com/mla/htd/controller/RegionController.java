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

import com.mla.htd.entity.Region;
import com.mla.htd.repository.RegionRepository;

@RestController
public class RegionController {
	
	@Autowired
	RegionRepository regionRepo;
	
	@PostMapping("/region")
	Region addRegion(@RequestBody Region region) {
		return regionRepo.save(region);
	}
	
	@PutMapping("/region")
	Region updateRegion(@RequestBody Region region) {
		return regionRepo.save(region);
	}
	
	@GetMapping("/region")
	List<Region> getAllRegions() {
		return regionRepo.findAll();
	}
	
	@DeleteMapping("/region/{id}")
	String deleteRegion(@PathVariable Long id) {
		regionRepo.deleteById(id);
		return "deleted successfully";
	}

}
