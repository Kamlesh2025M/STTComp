package com.example.controller;

import com.example.ignite.IgniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeDetailsController {

    @Autowired
    private IgniteService igniteService;

    @GetMapping("/trade-details/{key}")
    public String getTradeDetails(@PathVariable String key) {
        return igniteService.readFromCache(key);
    }
}
