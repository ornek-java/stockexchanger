package com.ndr.stockexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.StockDTO;
import com.ndr.stockexchanger.domain.Stock;
import com.ndr.stockexchanger.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	

	public StockDTO createStock(StockDTO requestStockDto) {
		Stock stock = new Stock();
		stock.setName(requestStockDto.getName());
		stock.setDescription(requestStockDto.getDescription());
		stock.setCurrentPrice(requestStockDto.getCurrentPrice());
		stock.setLastUpdate(requestStockDto.getLastUpdate());
		stock = stockRepository.save(stock);
		StockDTO responseStockDTO = new StockDTO();
		responseStockDTO.setId(stock.getId());
		responseStockDTO.setName(stock.getName());
		responseStockDTO.setDescription(stock.getDescription());
		responseStockDTO.setCurrentPrice(stock.getCurrentPrice());
		responseStockDTO.setLastUpdate(stock.getLastUpdate());
		return responseStockDTO;
	}


	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);
	}

}
