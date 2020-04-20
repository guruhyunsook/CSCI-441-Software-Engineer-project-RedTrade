package com.fhsu.redtrade.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    @GetMapping("/")
    public @ResponseBody String getAllUsers () {
        return "Welcome RedTrade !!";
    }
}
