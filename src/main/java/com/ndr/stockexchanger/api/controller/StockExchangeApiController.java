package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.StockExchangeCreateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeCreateResponseDTO;
import com.ndr.stockexchanger.api.dto.StockCreateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeAddStockRequestDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeListResponseDTO;
import com.ndr.stockexchanger.service.StockExchangeService;

import jakarta.persistence.OptimisticLockException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/stock-exchange")
public class StockExchangeApiController {

	@Autowired
	private StockExchangeService stockExchangeService;
	
	@PostMapping
	public StockExchangeCreateResponseDTO createStockExchange(@Valid @RequestBody StockExchangeCreateRequestDTO requestDto) {
		StockExchangeCreateResponseDTO responseDto= stockExchangeService.createStockExchange(requestDto);
		return responseDto;
	}
	
	@PostMapping("/{name}:addStock")
	public ResponseEntity<StockCreateRequestDTO> addStock(@PathVariable("name") String stockExchangeName, @Valid @RequestBody StockExchangeAddStockRequestDTO requestDTO) {
		try {
		if ( !stockExchangeService.addStock(stockExchangeName, requestDTO) ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}catch(OptimisticLockException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<StockExchangeListResponseDTO> getStockExchange(@PathVariable("name") String stockExchangeName) {
		StockExchangeListResponseDTO responseDTO = stockExchangeService.getStockExchange(stockExchangeName);
		if ( responseDTO != null )
			return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
	}
	
	@PostMapping("/{name}:deleteStock")
	public ResponseEntity<StockCreateRequestDTO> deleteStock(@PathVariable("name") String stockExchangeName, @Valid @RequestBody StockExchangeAddStockRequestDTO requestDTO) {
		try {
		if ( !stockExchangeService.removeStock(stockExchangeName, requestDTO) ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}catch(OptimisticLockException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
}
