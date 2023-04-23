# Spring Cloud Config Server

This project is a Spring Cloud Config Server developed for a microservice project. It serves as a centralized configuration service for all microservices in your system, providing versioned configuration data for applications.

## Features

- Centralized configuration management for microservices
- Spring Cloud Config Server integration
- Configurable security credentials for accessing the configuration
- YAML configuration for easy customization
- Java 17 for the latest language features

## Getting Started

### Prerequisites

Ensure that you have the following installed on your system:

- JDK 17 or later
- Maven 3.8.1 or later

### Build

To build the project, navigate to the project root directory and run the following command:

```bash
mvn clean install
```

This will compile the project, run tests, and package it as a JAR file.

### Running the project

To run the project, execute the following command from the project root directory:
```bash
java -jar target/config-server-0.0.1-SNAPSHOT.jar
```

The Config Server will start on port 8888 by default. You can change this by setting the CONFIG_SERVER_PORT environment variable or modifying the application.yml file.

## Configuration

The Config Server uses an `application.yml` file for its configuration.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.