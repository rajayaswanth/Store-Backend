package com.mla.htd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mla.htd.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

}
