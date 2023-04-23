# Discovery Server

The Discovery Server is a part of the Spring Cloud Microservice example. It is responsible for service registration and discovery, allowing microservices to locate and communicate with each other in a distributed system.

## Features

- Eureka Server for service registration and discovery
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
java -jar target/discovery-server-0.0.1-SNAPSHOT.jar
```

The Discovery Server will start and be ready to accept registration from other microservices.

## Configuration

The project uses the `bootstrap.yml` file for its configuration. It connects to the Config Server to fetch centralized configuration settings, allowing for easy management and updates of the application's configuration.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.