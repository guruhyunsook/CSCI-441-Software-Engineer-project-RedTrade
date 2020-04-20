package com.fhsu.redtrade.service;
import com.fhsu.redtrade.entity.Holding;
import com.fhsu.redtrade.repository.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoldingService {

    @Autowired
    private HoldingRepository holdingRepository;

    public List<Holding> findAllHoldings() {
        List<Holding> list = new ArrayList<>();
        holdingRepository.findAll().forEach(list::add);
        return list;
    }

    public Holding findById(String id) {

        return holdingRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public Holding createHolding(Holding holding) {
        //without id, then create
        return holdingRepository.save(holding);
    }

    public Holding updateHolding(Holding holding) {
        // with id, then update
        return holdingRepository.save(holding);
    }

    public void deleteHolding(String id) {
        holdingRepository.deleteById(Integer.parseInt(id));
    }
}
