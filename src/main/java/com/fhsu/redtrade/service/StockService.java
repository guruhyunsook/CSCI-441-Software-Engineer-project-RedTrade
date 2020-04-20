package com.fhsu.redtrade.service;

import com.fhsu.redtrade.entity.Stock;
import com.fhsu.redtrade.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> findAllStocks() {
        List<Stock> list = new ArrayList<>();
        stockRepository.findAll().forEach(list::add);
        return list;
    }

    public Stock findById(String id) {

        return stockRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public Stock createStock(Stock stock) {
        //without id, then create
        return stockRepository.save(stock);
    }

    public Stock updateStock(Stock stock) {
        // with id, then update
        return stockRepository.save(stock);
    }

    public void deleteStock(String id) {
        stockRepository.deleteById(Integer.parseInt(id));
    }
}
