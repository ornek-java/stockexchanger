package com.ndr.stockexchanger.api.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotNull;



public class StockDTO {
	
	private Long id;
	
	@NotNull(message = "Name cannot be empty!..")
	private String name;
	
	@NotNull(message = "Description cannot be empty!..")
	private String description;
	
	@NotNull(message = "Current Price cannot be empty!..")
	private BigDecimal currentPrice;
	
	private ZonedDateTime lastUpdate;
	
	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(ZonedDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	
	
}
