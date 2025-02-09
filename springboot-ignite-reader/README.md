# Spring Boot Ignite Reader

This project is a Spring Boot application that reads `TradeDetails` from an Ignite cache using `IgniteClient`. It supports distributed tracing with `traceId` and `spanId`.

## Running the Application

1. Ensure Ignite is running on `127.0.0.1:10800`.
2. Run the application using `mvn spring-boot:run`.

## Configuration

- Ignite cluster address can be configured in `src/main/resources/application.properties`.
