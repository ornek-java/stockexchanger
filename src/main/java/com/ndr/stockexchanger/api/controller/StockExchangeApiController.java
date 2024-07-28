package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.CreateStockExchangeRequestDTO;
import com.ndr.stockexchanger.api.dto.CreateStockExchangeResponseDTO;
import com.ndr.stockexchanger.api.dto.StockDTO;
import com.ndr.stockexchanger.api.dto.StockExchangeAddStockRequestDTO;
import com.ndr.stockexchanger.service.StockExchangeService;

import jakarta.persistence.OptimisticLockException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/stock-exchange")
public class StockExchangeApiController {

	@Autowired
	private StockExchangeService stockExchangeService;
	
	@PostMapping
	public CreateStockExchangeResponseDTO createStockExchange(@Valid @RequestBody CreateStockExchangeRequestDTO requestDto) {
		CreateStockExchangeResponseDTO responseDto= stockExchangeService.createStockExchange(requestDto);
		return responseDto;
	}
	
	@PatchMapping("/{name}")
	public ResponseEntity<StockDTO> updatePrice(@PathVariable("name") String stockExchangeName, @Valid @RequestBody StockExchangeAddStockRequestDTO requestDTO) {
		try {
		if ( !stockExchangeService.addStock(stockExchangeName, requestDTO) ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}catch(OptimisticLockException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
}
