package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.CreateStockExchangeRequestDTO;
import com.ndr.stockexchanger.api.dto.CreateStockExchangeResponseDTO;
import com.ndr.stockexchanger.service.StockExchangeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/stock-exchange")
public class StockExchangeApiController {

	@Autowired
	private StockExchangeService stockExchangeService;
	
	@PostMapping
	public CreateStockExchangeResponseDTO createStock(@Valid @RequestBody CreateStockExchangeRequestDTO requestDto) {
		CreateStockExchangeResponseDTO responseDto= stockExchangeService.createStockExchange(requestDto);
		return responseDto;
	}
	
}
