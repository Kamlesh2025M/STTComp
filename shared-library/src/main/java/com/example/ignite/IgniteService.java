package com.example.ignite;

import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.client.IgniteClientConfiguration;
import org.apache.ignite.table.KeyValueView;
import org.apache.ignite.lang.IgniteException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IgniteService {

    private IgniteClient igniteClient;
    private KeyValueView<String, String> cache;

    @Value("${ignite.cluster.address}")
    private String igniteClusterAddress;

    public IgniteService() {
        try {
            // Configure Ignite client correctly
            igniteClient = IgniteClient.builder()
                    .addresses(igniteClusterAddress)
                    .build();

            // Get table (Ignite 3 uses tables instead of caches)
            cache = igniteClient.tables()
                    .table("TradeDetailsTable")
                    .keyValueView(String.class, String.class);

        } catch (IgniteException e) {
            e.printStackTrace();
        }
    }

    public void writeToCache(String key, String value) {
        cache.put(null, key, value);  // Ignite 3 requires transactions (null = auto)
    }

    public String readFromCache(String key) {
        return cache.get(null, key);  // Ignite 3 requires transactions (null = auto)
    }
}
