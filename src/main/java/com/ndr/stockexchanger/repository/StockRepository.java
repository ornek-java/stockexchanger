package com.ndr.stockexchanger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ndr.stockexchanger.domain.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

	

}
