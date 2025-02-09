# Spring Boot Kafka Ignite

This project is a Spring Boot application that consumes messages from a Kafka topic called `TradeDetails` and saves them in an Ignite cluster. It supports distributed tracing with `traceId` and `spanId`.

## Features

- **Kafka Consumer**: Listens to messages from a specified Kafka topic.
- **Ignite Integration**: Writes consumed messages to an Ignite cluster.
- **Distributed Logging**: Implements trace ID and span ID for tracking requests across services.

## Project Structure

```
springboot-kafka-ignite
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── SpringbootKafkaIgniteApplication.java
│   │   │           ├── config
│   │   │           │   └── KafkaConfig.java
│   │   │           ├── consumer
│   │   │           │   └── KafkaConsumer.java
│   │   │           ├── ignite
│   │   │           │   └── IgniteService.java
│   │   │           └── logging
│   │   │               └── LoggingConfig.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── logback-spring.xml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── SpringbootKafkaIgniteApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Running the Application

1. Ensure Kafka is running on `localhost:9092`.
2. Ensure Ignite is running on `127.0.0.1:10800`.
3. Run the application using `mvn spring-boot:run`.

## Configuration

- Kafka bootstrap servers can be configured in `src/main/resources/application.properties`.
- Ignite cluster address can be configured in `src/main/resources/application.properties`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.