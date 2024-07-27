package com.ndr.stockexchanger.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/stock")
public class StockApiController {

	@GetMapping("/userResource")
	public String getUserResource() {
		return "User Resource";
	}
	
	@GetMapping("/adminResource")
	public String getAdminResource() {
		return "Admin Resource1";
	}
	
	@GetMapping("/publicResource")
	public String getPublicResource() {
		return "Public Resource";
	}
}
