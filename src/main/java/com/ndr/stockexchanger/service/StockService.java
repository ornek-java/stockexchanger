package com.ndr.stockexchanger.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.PriceUpdateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockCreateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockCreateResponseDTO;
import com.ndr.stockexchanger.domain.Stock;
import com.ndr.stockexchanger.repository.StockRepository;

import jakarta.validation.Valid;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	

	public StockCreateResponseDTO createStock(StockCreateRequestDTO requestStockDto) {
		Stock stock = new Stock();
		stock.setName(requestStockDto.getName());
		stock.setDescription(requestStockDto.getDescription());
		stock.setCurrentPrice(requestStockDto.getCurrentPrice());
		stock.setLastUpdate(ZonedDateTime.now());
		stock = stockRepository.save(stock);
		
		return generateStockCreateResponseDTO(stock);
	}


	public boolean deleteStock(Long stockId) {
		Optional<Stock> optStock = stockRepository.findById(stockId);
		if (optStock.isEmpty())
			return false;
		stockRepository.deleteById(stockId);
		return true;
	}


	public StockCreateResponseDTO updatePrice(Long stockId, @Valid PriceUpdateRequestDTO priceUpdateRequest) {
		Optional<Stock> optStock = stockRepository.findById(stockId);
		if (optStock.isEmpty())
			return null;
		Stock updateStock = optStock.get();
		updateStock.setCurrentPrice(priceUpdateRequest.getNewPrice());
		updateStock.setLastUpdate(ZonedDateTime.now());
		updateStock = stockRepository.save(updateStock);
		return generateStockCreateResponseDTO(updateStock);
	}


	private StockCreateResponseDTO generateStockCreateResponseDTO(Stock stock) {
		StockCreateResponseDTO responseDTO = new StockCreateResponseDTO();
		responseDTO.setId(stock.getId());
		responseDTO.setName(stock.getName());
		responseDTO.setDescription(stock.getDescription());
		responseDTO.setCurrentPrice(stock.getCurrentPrice());
		responseDTO.setLastUpdate(stock.getLastUpdate());
		responseDTO.setVersion(stock.getVersion());
		
		return responseDTO;
	}

}
