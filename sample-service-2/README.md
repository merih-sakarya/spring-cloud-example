# Sample Service 2

`sample-service-2` is a microservice within the `spring-cloud-microservice-example` project that demonstrates the capabilities of a Spring Boot-based microservice.

## Features

- Spring Cloud Config for centralized configuration management
- Eureka Client for service registration and discovery
- Spring Boot Actuator for application monitoring
- Spring Security and JWT for authentication and authorization
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
java -jar target/sample-service-2-0.0.1-SNAPSHOT.jar
```

`sample-service-2` will start and register itself with the Discovery Server.

## Endpoints

The available endpoints for this service are:

* `/echo`: Returns an echo response from `sample-service-2`.
* `/echo/service-2-to-service-1`: Returns an echo response from `sample-service-1` through the `sample-service-1-client` library.

## Configuration

The project uses the `bootstrap.yml` file for its initial configuration. It connects to the Config Server to fetch centralized configuration settings, allowing for easy management and updates of the application's configuration.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.