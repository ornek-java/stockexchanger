package com.ndr.stockexchanger.api.dto;

import java.util.HashSet;
import java.util.Set;

public class StockExchangeListResponseDTO extends StockExchangeBaseDTO{

	private Long id;
	private String name;
	private String description;
	private Boolean isLiveInMarket;
	private Long version;
	
	private Set<StockCreateResponseDTO> stockDTO = new HashSet<>();
	
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
	public Boolean getIsLiveInMarket() {
		return isLiveInMarket;
	}
	public void setIsLiveInMarket(Boolean isLiveInMarket) {
		this.isLiveInMarket = isLiveInMarket;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Set<StockCreateResponseDTO> getStockDTO() {
		return stockDTO;
	}
	
	public void setStockDTO(Set<StockCreateResponseDTO> stockDTO) {
		this.stockDTO = stockDTO;
	}
	
	
	
}
