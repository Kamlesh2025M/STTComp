package com.example.ignite;

import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.client.ClientCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IgniteService {

    private final ClientCache<String, String> cache;

    @Autowired
    public IgniteService(IgniteClient igniteClient) {
        this.cache = igniteClient.getOrCreateCache("TradeDetailsCache");
    }

    public String readFromCache(String key) {
        return cache.get(key);
    }
}
