package com.example.logging;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Configuration
public class LoggingConfig {

    @Bean
    public OncePerRequestFilter logFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                try {
                    String traceId = UUID.randomUUID().toString();
                    MDC.put("traceId", traceId);
                    MDC.put("spanId", traceId); // In a real scenario, spanId would be different for each span
                    filterChain.doFilter(request, response);
                } finally {
                    MDC.clear();
                }
            }
        };
    }
}
