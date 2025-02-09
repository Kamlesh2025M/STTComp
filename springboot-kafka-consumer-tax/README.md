# Spring Boot Kafka Consumer Tax

This project is a Spring Boot application that consumes messages from a Kafka topic called `TradeDetails`, calculates securities tax, and updates the message in an Ignite cache. It supports distributed tracing with `traceId` and `spanId`.

## Running the Application

1. Ensure Kafka is running on `localhost:9092`.
2. Ensure Ignite is running on `127.0.0.1:10800`.
3. Run the application using `mvn spring-boot:run`.

## Configuration

- Kafka bootstrap servers can be configured in `src/main/resources/application.properties`.
- Ignite cluster address can be configured in `src/main/resources/application.properties`.