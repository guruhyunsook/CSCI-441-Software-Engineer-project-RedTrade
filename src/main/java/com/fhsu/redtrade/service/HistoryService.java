package com.fhsu.redtrade.service;

import com.fhsu.redtrade.entity.History;
import com.fhsu.redtrade.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> findAllHistorys() {
        List<History> list = new ArrayList<>();
        historyRepository.findAll().forEach(list::add);
        return list;
    }

    public History findById(String id) {

        return historyRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public History createHistory(History history) {
        //without id, then create
        return historyRepository.save(history);
    }

    public History updateHistory(History history) {
        // with id, then update
        return historyRepository.save(history);
    }

    public void deleteHistory(String id) {
        historyRepository.deleteById(Integer.parseInt(id));
    }
}
