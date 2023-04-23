# Sample Service 1 Client

`sample-service-1-client` is a library within the `spring-cloud-microservice-example` project that provides an easy-to-use client for the `sample-service-1` microservice. It includes a Feign client, OAuth2 support, and Spring Boot auto-configuration.

## Features

- Feign client for the sample-service-1 microservice
- OAuth2 client support for secure communication with the microservice
- Spring Boot auto-configuration
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

### Integrating the Library

To use this library in your project, add the following dependency to your `pom.xml` file:

```bash
<dependency>
    <groupId>com.microservice.example</groupId>
    <artifactId>sample-service-1-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Configuration

The project uses the `sample-service-1-client-config.yml` file for its initial configuration. You can override these values in your application's configuration file.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.