package com.ndr.stockexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.CreateStockExchangeRequestDTO;
import com.ndr.stockexchanger.api.dto.CreateStockExchangeResponseDTO;
import com.ndr.stockexchanger.domain.StockExchange;
import com.ndr.stockexchanger.repository.StockExchangeRepository;

import jakarta.validation.Valid;

@Service
public class StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;

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
		
		return responseDTO;
	}
	
	
}
