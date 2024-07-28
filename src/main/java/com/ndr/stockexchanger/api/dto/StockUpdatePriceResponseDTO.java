package com.ndr.stockexchanger.api.dto;

import java.time.ZonedDateTime;

public class StockUpdatePriceResponseDTO extends StockBaseResponseDTO{
	
	private ZonedDateTime lastUpdate;
	
	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(ZonedDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
