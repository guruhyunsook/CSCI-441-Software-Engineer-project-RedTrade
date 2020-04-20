package com.fhsu.redtrade.controller;

import com.fhsu.redtrade.entity.Stock;
import com.fhsu.redtrade.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/stocks")
public class StockController {

    private static Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    StockService stockService;

    @GetMapping("/")
    public ResponseEntity<List<Stock>> getAllStocks () {
        logger.info("Getting all stocks");

        return ResponseEntity.ok(stockService.findAllStocks());
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<Stock> getUserById (@PathVariable(required = false) String stockId) {
        logger.info("Getting a stock by id = {}", stockId);

        return ResponseEntity.ok(stockService.findById(stockId));
    }

    @PostMapping("/")
    public ResponseEntity<Stock> createStock (@RequestBody Stock stock) {
        logger.info("Creating a stock = {}", stock);

        return ResponseEntity.ok(stockService.createStock(stock));
    }

    @PutMapping("/")
    public ResponseEntity<Stock> updateStock (@RequestBody Stock stock) {
        logger.info("Updating stock = {}", stock.getSymbol());

        return ResponseEntity.ok(stockService.createStock(stock));
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<String> deleteUserById (@PathVariable(required = false) String stockId) {
        logger.info("Deleting stockId = {}", stockId);

        stockService.deleteStock(stockId);

        return ResponseEntity.ok("Successfully deleted !");
    }
}