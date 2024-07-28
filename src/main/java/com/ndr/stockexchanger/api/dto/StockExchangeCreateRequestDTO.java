package com.ndr.stockexchanger.api.dto;

import jakarta.validation.constraints.NotNull;

public class StockExchangeCreateRequestDTO {

	@NotNull(message = "Name cannot be empty!..")
	private String name;
	
	@NotNull(message = "Descrition cannot be empty!..")
	private String description;
	
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
	
	
	
}
