package com.ndr.stockexchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndr.stockexchanger.api.dto.CreateStockExchangeRequestDTO;
import com.ndr.stockexchanger.api.dto.CreateStockExchangeResponseDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeAddStockRequestDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeListResponseDTO;
import com.ndr.stockexchanger.domain.Stock;
import com.ndr.stockexchanger.domain.StockExchange;
import com.ndr.stockexchanger.repository.StockExchangeRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	@Autowired
	private StockService stockService;
	
	

	public CreateStockExchangeResponseDTO createStockExchange(@Valid CreateStockExchangeRequestDTO requestDto) {
		StockExchange stockExchange = new StockExchange();
		stockExchange.setName(requestDto.getName());
		stockExchange.setDescription(requestDto.getDescription());
		stockExchange = stockExchangeRepository.save(stockExchange);
		stockExchange.setLiveInMarket(false);
		
		return generateResponseDTO(stockExchange);
	}

	private CreateStockExchangeResponseDTO generateResponseDTO(StockExchange stockExchange) {
		CreateStockExchangeResponseDTO responseDTO = new CreateStockExchangeResponseDTO();
		responseDTO.setId(stockExchange.getId());
		responseDTO.setName(stockExchange.getName());
		responseDTO.setDescription(stockExchange.getDescription());
		responseDTO.setIsLiveInMarket(stockExchange.isLiveInMarket());
		responseDTO.setVersion(stockExchange.getVersion());
		
		return responseDTO;
	}

	@Transactional
	public boolean addStock(String stockExchangeName, @Valid StockExchangeAddStockRequestDTO requestDTO) {
		StockExchange stockExchange = stockExchangeRepository.findByName(stockExchangeName);
		Stock stock = stockService.findByName(requestDTO.getStockName());
		if ( stockExchange == null ||  stock == null ) {
			return false; // i.e. resource not found
		}
		stockExchange.getStocks().add(stock);
		if ( stockExchange.getStocks().size() >= 5 && !stockExchange.isLiveInMarket() ) {
			stockExchange.setLiveInMarket(true);
		}
		stockExchangeRepository.save(stockExchange);
		return true;
		
	}

	public StockExchangeListResponseDTO getStockExchange(String stockExchangeName) {
		StockExchange stockExchange = stockExchangeRepository.findByName(stockExchangeName);
		if ( stockExchange == null)
			return null;
		else 
			return generateStockExchangeListResponseDTO(stockExchange);
	}

	private StockExchangeListResponseDTO generateStockExchangeListResponseDTO(StockExchange stockExchange) {
		StockExchangeListResponseDTO responseDTO = new StockExchangeListResponseDTO();
		responseDTO.setId(stockExchange.getId());
		responseDTO.setName(stockExchange.getName());
		responseDTO.setDescription(stockExchange.getDescription());
		responseDTO.setVersion(stockExchange.getVersion());
		responseDTO.setIsLiveInMarket(stockExchange.isLiveInMarket());
		stockExchange.getStocks().forEach(stock -> 
							{
								responseDTO.getStockDTO().add(stockService.generateStockCreateResponseDTO(stock));
							});
		
		return responseDTO;
	}

	@Transactional
	public boolean removeStock(String stockExchangeName, @Valid StockExchangeAddStockRequestDTO requestDTO) {
		StockExchange stockExchange = stockExchangeRepository.findByName(stockExchangeName);
		Stock stock = stockService.findByName(requestDTO.getStockName());
		if ( stockExchange == null ||  stock == null ) {
			return false; // i.e. resource not found
		}
		stockExchange.getStocks().remove(stock);
		if ( stockExchange.getStocks().size() < 5 && stockExchange.isLiveInMarket() ) {
			stockExchange.setLiveInMarket(false);
		}
		stockExchangeRepository.save(stockExchange);
		return true;
	}
	
	
}
