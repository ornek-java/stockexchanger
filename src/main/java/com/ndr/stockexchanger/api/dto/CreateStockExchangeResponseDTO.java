package com.ndr.stockexchanger.api.dto;

public class CreateStockExchangeResponseDTO {

	private Long id;
	private String name;
	private String description;
	private Boolean isLiveInMarket;
	private Long version;
	
	
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
	public void setVersion(Long version) {
		this.version = version; 
		
	}
	public Long getVersion() {
		return version;
	}
	
	
	
}
