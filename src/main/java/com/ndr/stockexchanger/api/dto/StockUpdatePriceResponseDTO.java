package com.ndr.stockexchanger.api.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotNull;



public class StockUpdatePriceResponseDTO {
	
	
	private String name;
	private BigDecimal currentPrice;
	private ZonedDateTime lastUpdate;
	private int version;
	
	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(ZonedDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
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
	
	
	
}
