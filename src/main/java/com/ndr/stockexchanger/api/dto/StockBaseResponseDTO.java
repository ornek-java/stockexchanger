package com.ndr.stockexchanger.api.dto;

import java.math.BigDecimal;

public class StockBaseResponseDTO {

	private String name;
	private String description;
	private BigDecimal currentPrice;
	private int version;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	public void setVersion(int version) {
		this.version = version;
		
	}
	public int getVersion() {
		return version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
