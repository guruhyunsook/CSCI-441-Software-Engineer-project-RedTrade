package com.fhsu.redtrade.controller;

import com.fhsu.redtrade.entity.Holding;
import com.fhsu.redtrade.service.HoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/holdings")
public class HoldingController {

    private static Logger logger = LoggerFactory.getLogger(HoldingController.class);

    @Autowired
    HoldingService holdingService;

    @GetMapping("/")
    public ResponseEntity<List<Holding>> getAllHoldings () {
        logger.info("Getting all holdings");

        return ResponseEntity.ok(holdingService.findAllHoldings());
    }

    @GetMapping("/{holdingId}")
    public ResponseEntity<Holding> getHoldingById (@PathVariable(required = false) String holdingId) {
        logger.info("Getting a user by id = {}", holdingId);

        return ResponseEntity.ok(holdingService.findById(holdingId));
    }

    @PostMapping("/")
    public ResponseEntity<Holding> createHolding (@RequestBody Holding holding) {
        logger.info("Creating a holding = {}", holding);

        return ResponseEntity.ok(holdingService.createHolding(holding));
    }

    @PutMapping("/")
    public ResponseEntity<Holding> updateHolding (@RequestBody Holding holding) {
        logger.info("Updating holdingId = {}", holding.getId());

        return ResponseEntity.ok(holdingService.createHolding(holding));
    }

    @DeleteMapping("/{holdingId}")
    public ResponseEntity<String> deleteHoldingById (@PathVariable(required = false) String holdingId) {
        logger.info("Deleting holdingId = {}", holdingId);

        holdingService.deleteHolding(holdingId);

        return ResponseEntity.ok("Successfully deleted !");
    }
}