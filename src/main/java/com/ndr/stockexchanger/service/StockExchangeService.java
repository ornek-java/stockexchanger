package com.ndr.stockexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.CreateStockExchangeRequestDTO;
import com.ndr.stockexchanger.api.dto.CreateStockExchangeResponseDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeAddStockRequestDTO;
import com.ndr.stockexchanger.domain.Stock;
import com.ndr.stockexchanger.domain.StockExchange;
import com.ndr.stockexchanger.repository.StockExchangeRepository;
import com.ndr.stockexchanger.repository.StockRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	

	public CreateStockExchangeResponseDTO createStockExchange(@Valid CreateStockExchangeRequestDTO requestDto) {
		StockExchange stockExchange = new StockExchange();
		stockExchange.setName(requestDto.getName());
		stockExchange.setDescription(requestDto.getDescription());
		stockExchange = stockExchangeRepository.save(stockExchange);
		stockExchange.setIsLiveInMarket(false);
		
		return generateResponseDTO(stockExchange);
	}

	private CreateStockExchangeResponseDTO generateResponseDTO(StockExchange stockExchange) {
		CreateStockExchangeResponseDTO responseDTO = new CreateStockExchangeResponseDTO();
		responseDTO.setId(stockExchange.getId());
		responseDTO.setName(stockExchange.getName());
		responseDTO.setDescription(stockExchange.getDescription());
		responseDTO.setIsLiveInMarket(stockExchange.getIsLiveInMarket());
		responseDTO.setVersion(stockExchange.getVersion());
		
		return responseDTO;
	}

	@Transactional
	public boolean addStock(String stockExchangeName, @Valid StockExchangeAddStockRequestDTO requestDTO) {
		StockExchange stockExchange = stockExchangeRepository.findByName(stockExchangeName);
		Stock stock = stockRepository.findByName(requestDTO.getStockName());
		if ( stockExchange == null ||  stock == null ) {
			return false; // i.e. resource not found
		}
		stockExchange.getStocks().add(stock);
		return true;
		
	}
	
	
}
