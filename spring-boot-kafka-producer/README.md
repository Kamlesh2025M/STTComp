# Spring Boot Kafka Producer

This project is a Spring Boot application that produces messages to a Kafka topic called `TradeDetails`. It supports distributed tracing with `traceId` and `spanId`.

## Running the Application

1. Ensure Kafka is running on `localhost:9092`.
2. Run the application using `mvn spring-boot:run`.

## Configuration

- Kafka bootstrap servers can be configured in `src/main/resources/application.properties`.