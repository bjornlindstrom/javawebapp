package com.bjorn.service;

import com.bjorn.controller.StockDto;
import com.bjorn.domain.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Björn on 2015-12-05.
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<StockDto> getAllStocks() {

        return StreamSupport.stream(stockRepository.findAll().spliterator(), false).map(
                stock -> {
                    return new StockDto(stock.getName(), stock.getShortName());
                }).collect(Collectors.<StockDto>toList());

    }


}
