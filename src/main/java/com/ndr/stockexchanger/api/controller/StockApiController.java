package com.ndr.stockexchanger.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndr.stockexchanger.api.dto.PriceUpdateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockCreateRequestDTO;
import com.ndr.stockexchanger.api.dto.StockCreateResponseDTO;
import com.ndr.stockexchanger.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/stock")
public class StockApiController {

	@Autowired
	private StockService stockService;
	
	@PostMapping
	public StockCreateResponseDTO createStock(@Valid @RequestBody StockCreateRequestDTO requestStockDto) {
		StockCreateResponseDTO responseStockDto = stockService.createStock(requestStockDto);
		return responseStockDto;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStock(@PathVariable("id") Long stockId) {
		if ( !stockService.deleteStock(stockId) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<StockCreateResponseDTO> updatePrice(@PathVariable("id") Long stockId, @Valid @RequestBody PriceUpdateRequestDTO priceUpdateRequest) {
		StockCreateResponseDTO updatedStockDTO = stockService.updatePrice(stockId, priceUpdateRequest);
		if ( updatedStockDTO != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(updatedStockDTO);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
