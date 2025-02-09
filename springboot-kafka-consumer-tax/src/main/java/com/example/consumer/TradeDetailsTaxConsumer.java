package com.example.consumer;

import com.example.ignite.IgniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeDetailsTaxConsumer {

    @Autowired
    private IgniteService igniteService;

    @KafkaListener(topics = "TradeDetails", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        // Calculate Securities Tax and update the message
        String updatedMessage = message + " - Tax Calculated";
        igniteService.writeToCache("TradeDetails", updatedMessage);
    }
}