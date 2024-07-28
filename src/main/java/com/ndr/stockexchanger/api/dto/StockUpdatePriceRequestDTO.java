package com.ndr.stockexchanger.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class StockUpdatePriceRequestDTO {

	@NotNull(message="New Price cannot be null!..")
	private BigDecimal newPrice;

	public BigDecimal getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	
	
	
}
