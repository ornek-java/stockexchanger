package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.StockDTO;
import com.ndr.stockexchanger.service.StockService;

@RestController
@RequestMapping(path = "/api/v1/stock")
public class StockApiController {

	@Autowired
	private StockService stockService;
	
	@PostMapping()
	public StockDTO createStock(StockDTO requestStockDto) {
		StockDTO responseStockDto= stockService.createStock(requestStockDto);
		return responseStockDto;
	}
	
	/*
	@GetMapping("/adminResource")
	public String getAdminResource() {
		return "Admin Resource1";
	}
	
	@GetMapping("/publicResource")
	public String getPublicResource() {
		return "Public Resource";
	}*/
	
}
