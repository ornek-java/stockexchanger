package com.ndr.stockexchanger.api.dto;

import java.util.HashSet;
import java.util.Set;

public class StockExchangeListResponseDTO extends StockExchangeBaseResponseDTO{

	private Set<StockListResponseDTO> stockDTO = new HashSet<>();
	
	
	public Set<StockListResponseDTO> getStockDTO() {
		return stockDTO;
	}
	
	public void setStockDTO(Set<StockListResponseDTO> stockDTO) {
		this.stockDTO = stockDTO;
	}
	
	
	
}
