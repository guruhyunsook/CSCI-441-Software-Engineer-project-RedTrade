package com.fhsu.redtrade.controller;

import com.fhsu.redtrade.entity.History;
import com.fhsu.redtrade.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/historys")
public class HistoryController {

    private static Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @Autowired
    HistoryService historyService;

    @GetMapping("/")
    public ResponseEntity<List<History>> getAllHistorys () {
        logger.info("Getting all historys");

        return ResponseEntity.ok(historyService.findAllHistorys());
    }

    @GetMapping("/{historyId}")
    public ResponseEntity<History> getHistoryById (@PathVariable(required = false) String historyId) {
        logger.info("Getting a history by id = {}", historyId);

        return ResponseEntity.ok(historyService.findById(historyId));
    }

    @PostMapping("/")
    public ResponseEntity<History> createHistory (@RequestBody History history) {
        logger.info("Creating a history = {}", history);

        return ResponseEntity.ok(historyService.createHistory(history));
    }

    @PutMapping("/")
    public ResponseEntity<History> updateHistory (@RequestBody History history) {
        logger.info("Updating historyId = {}", history.getId());

        return ResponseEntity.ok(historyService.createHistory(history));
    }

    @DeleteMapping("/{historyId}")
    public ResponseEntity<String> deleteHistoryById (@PathVariable(required = false) String historyId) {
        logger.info("Deleting historyId = {}", historyId);

        historyService.deleteHistory(historyId);

        return ResponseEntity.ok("Successfully deleted !");
    }
}