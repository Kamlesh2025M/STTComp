package com.example.consumer;

import com.example.ignite.IgniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeDetailsConsumer {

    @Autowired
    private IgniteService igniteService;

    @KafkaListener(topics = "TradeDetails", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        // Perform operations to enrich data
        String updatedMessage = message + " - Data Enriched";
        igniteService.writeToCache("TradeDetails", updatedMessage);
    }
}
