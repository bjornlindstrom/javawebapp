package com.bjorn.controller;

import com.bjorn.domain.Stock;
import com.bjorn.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Björn on 2015-12-05.
 */
@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;


    @RequestMapping(method = RequestMethod.GET)
    public List<StockDto> getAllStocks(){

        return stockService.getAllStocks();
    }


}
