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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class RegionController {
	
	@Autowired
	RegionRepository regionRepo;
	
	/**
	 * Creates Region
	 * @param region
	 * @return
	 */
	@PostMapping("/region")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Region addRegion(@RequestBody Region region) {
		return regionRepo.save(region);
	}
	
	/**
	 * Updates Region
	 * @param region
	 * @return
	 */
	@PutMapping("/region")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	Region updateRegion(@RequestBody Region region) {
		return regionRepo.save(region);
	}
	
	/**
	 * Gets region list
	 * @return
	 */
	@GetMapping("/region")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	List<Region> getAllRegions() {
		return regionRepo.findAll();
	}
	
	/**
	 * Deletes region by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping("/region/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value="JWT") })
	String deleteRegion(@PathVariable Long id) {
		regionRepo.deleteById(id);
		return "deleted successfully";
	}

}
