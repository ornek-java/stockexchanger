package com.ndr.stockexchanger.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.PriceUpdateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockDTO;
import com.ndr.stockexchanger.domain.Stock;
import com.ndr.stockexchanger.repository.StockRepository;

import jakarta.validation.Valid;

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
		
		return generateStockDTO(stock);
	}


	public boolean deleteStock(Long stockId) {
		Optional<Stock> optStock = stockRepository.findById(stockId);
		if (optStock.isEmpty())
			return false;
		stockRepository.deleteById(stockId);
		return true;
	}


	public StockDTO updatePrice(Long stockId, @Valid PriceUpdateRequestDTO priceUpdateRequest) {
		Optional<Stock> optStock = stockRepository.findById(stockId);
		if (optStock.isEmpty())
			return null;
		Stock updateStock = optStock.get();
		updateStock.setCurrentPrice(priceUpdateRequest.getNewPrice());
		updateStock.setLastUpdate(ZonedDateTime.now());
		updateStock = stockRepository.save(updateStock);
		return generateStockDTO(updateStock);
	}


	private StockDTO generateStockDTO(Stock stock) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setId(stock.getId());
		stockDTO.setName(stock.getName());
		stockDTO.setDescription(stock.getDescription());
		stockDTO.setCurrentPrice(stock.getCurrentPrice());
		stockDTO.setLastUpdate(stock.getLastUpdate());
		return stockDTO;
	}

}
