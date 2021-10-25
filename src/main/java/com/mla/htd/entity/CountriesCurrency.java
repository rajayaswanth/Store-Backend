package com.mla.htd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries_currency")
public class CountriesCurrency implements Serializable {

	private static final long serialVersionUID = -445390191066711700L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "country_id")
	private Country county;
	
	@OneToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;

	public Country getCounty() {
		return county;
	}

	public void setCounty(Country county) {
		this.county = county;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
