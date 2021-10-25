package com.mla.htd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mla.htd.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
