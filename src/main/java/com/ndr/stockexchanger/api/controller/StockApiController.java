package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.StockDTO;
import com.ndr.stockexchanger.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/stock")
public class StockApiController {

	@Autowired
	private StockService stockService;
	
	@PostMapping
	public StockDTO createStock(@Valid @RequestBody StockDTO requestStockDto) {
		StockDTO responseStockDto= stockService.createStock(requestStockDto);
		return responseStockDto;
	}
	
	@DeleteMapping("/{id}")
	public Boolean deleteStock(@PathVariable("id") Long stockId) {
		stockService.deleteStock(stockId);
		return true;
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
