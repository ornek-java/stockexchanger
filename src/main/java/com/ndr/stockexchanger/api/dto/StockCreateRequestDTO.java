package com.ndr.stockexchanger.api.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotNull;



public class StockCreateRequestDTO {
	
	
	
	@NotNull(message = "Name cannot be empty!..")
	private String name;
	
	@NotNull(message = "Description cannot be empty!..")
	private String description;
	
	@NotNull(message = "Current Price cannot be empty!..")
	private BigDecimal currentPrice;
			
	
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
