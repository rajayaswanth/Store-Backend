package com.mla.htd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales implements Serializable {
	
	private static final long serialVersionUID = 7951350300406297185L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "sales_channel")
	private String salesChannel;

	@Column(name = "order_number")
	private String orderNumber;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@Column(name = "net_amount")
	private Integer netAmount;
	
	private Integer tax;
	
	@Column(name = "shipping_cost")
	private Integer shippingCost;
	
	@Column(name = "gross_amount")
	private Integer grossAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Integer getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Integer netAmount) {
		this.netAmount = netAmount;
	}

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}

	public Integer getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Integer shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Integer getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Integer grossAmount) {
		this.grossAmount = grossAmount;
	}

}
