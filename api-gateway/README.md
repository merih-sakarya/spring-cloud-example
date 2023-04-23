# API Gateway

This is the API Gateway project for the Spring Cloud Microservice example. The API Gateway acts as a single entry point for all microservices within the system, providing load balancing, routing, and other features to improve the system's scalability and maintainability.

## Features

- Spring Cloud Gateway for routing and load balancing
- Eureka Client for service discovery
- Spring Cloud Config for centralized configuration management
- YAML configuration for easy customization
- Java 17 for the latest language features

## Getting Started

### Prerequisites

Ensure that you have the following installed on your system:

- JDK 17 or later
- Maven 3.8.1 or later

### Building the project

To build the project, navigate to the project root directory and run the following command:

```bash
mvn clean install
```

This will compile the project, run tests, and package it as a JAR file.

### Running the project

To run the project, execute the following command from the project root directory:
```bash
java -jar target/api-gateway-0.0.1-SNAPSHOT.jar
```

The API Gateway will start and register itself with the Eureka Server.

## Configuration

The project uses the `bootstrap.yml` file for its configuration. It connects to the Config Server to fetch centralized configuration settings, allowing for easy management and updates of the application's configuration.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the MIT License