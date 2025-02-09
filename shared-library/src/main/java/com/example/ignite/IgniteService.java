package com.example.ignite;

import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientConfiguration;
import org.apache.ignite.Ignition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IgniteService {

    private IgniteClient igniteClient;
    private ClientCache<String, String> cache;

    @Value("${ignite.cluster.address}")
    private String igniteClusterAddress;

    public IgniteService() {
        try {
            ClientConfiguration cfg = new ClientConfiguration().setAddresses(igniteClusterAddress);
            igniteClient = Ignition.startClient(cfg);
            cache = igniteClient.getOrCreateCache("TradeDetailsCache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToCache(String key, String value) {
        cache.put(key, value);
    }

    public String readFromCache(String key) {
        return cache.get(key);
    }
}
