package com.mla.htd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mla.htd.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
