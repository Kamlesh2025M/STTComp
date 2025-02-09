package com.example.config;

import org.apache.ignite.client.ClientConfiguration;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.Ignition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class IgniteConfig {

    @Value("${ignite.cluster.address}")
    private String igniteClusterAddress;

    @Bean
    public IgniteClient igniteClient() {
        ClientConfiguration cfg = new ClientConfiguration().setAddresses(igniteClusterAddress);
        return Ignition.startClient(cfg);
    }
}
