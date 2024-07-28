package com.ndr.stockexchanger.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="STOCK_EXCHANGES")
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "LIVE_IN_MARKET")
	private Boolean isLiveInMarket;
	
	@Version
	private Long Version;
	
	
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
		return Version;
	}
	
	
}
