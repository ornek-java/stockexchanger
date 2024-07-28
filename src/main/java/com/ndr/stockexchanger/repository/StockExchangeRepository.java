package com.ndr.stockexchanger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ndr.stockexchanger.domain.StockExchange;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchange, Long>{

}
