# Spring Cloud Microservice Example

This project is a sample microservice architecture using Spring Cloud. It demonstrates how to build, deploy, and manage a scalable and maintainable microservice system. The example includes several components such as a discovery server, config server, API gateway, auth server, and multiple sample services.

1. [Discovery Server](#discovery-server)
2. [Config Server](#config-server)
3. [API Gateway](#api-gateway)
4. [Auth Server](#auth-server)
5. [Sample Service 1](#sample-service-1)
6. [Sample Service 1 Client](#sample-service-1-client)
7. [Sample Service 2](#sample-service-2)
8. [Sample Service 2 Client](#sample-service-2-client)

## Discovery Server

The Discovery Server is responsible for service registration and discovery, allowing microservices to locate and communicate with each other in a distributed system.
[Learn more](./discovery-server/README.md)

## Config Server

The Config Server serves as a centralized configuration service for all microservices in your system, providing versioned configuration data for applications.
[Learn more](./config-server/README.md)

## API Gateway

The API Gateway acts as a single entry point for all microservices within the system, providing load balancing, routing, and other features to improve the system's scalability and maintainability.
[Learn more](./api-gateway/README.md)

## Auth Server

The Auth Server is responsible for handling authentication and authorization of users, providing secure access to protected resources across microservices.
[Learn more](./auth-server/README.md)

## Sample Service 1

Sample Service 1 is a microservice within the project that demonstrates the capabilities of a Spring Boot-based microservice.
[Learn more](./sample-service-1/README.md)

## Sample Service 1 Client

Sample Service 1 Client is a library within the project that provides an easy-to-use client for the Sample Service 1 microservice. It includes a Feign client, OAuth2 support, and Spring Boot auto-configuration.
[Learn more](./sample-service-1-client/README.md)

## Sample Service 2

Sample Service 2 is a microservice within the project that demonstrates the capabilities of a Spring Boot-based microservice.
[Learn more](./sample-service-2/README.md)

## Sample Service 2 Client

Sample Service 2 Client is a library within the project that provides an easy-to-use client for the Sample Service 2 microservice. It includes a Feign client, OAuth2 support, and Spring Boot auto-configuration.
[Learn more](./sample-service-2-client/README.md)

## Getting Started

Please refer to the README files of each individual component for instructions on how to build, configure, and run them.

## Endpoints

#### Sample Service 1 Endpoints

1.
    **Endpoint:**
    ```url
    GET http://127.0.0.1:4000/service-1/echo
    ```

    **Curl:**
    ```bash
    curl --location 'http://127.0.0.1:4000/service-1/echo' \
    --header 'Authorization: Bearer {authorization token}'
    ```

    **Response:**
    ```json
    {
      "echo": "[sample-service-1] : echo"
    }
    ```

2.
    **Endpoint:**
    ```url
    GET http://127.0.0.1:4000/service-1/echo/service-1-to-service-2
    ```

    **Curl:**
    ```bash
    curl --location 'http://127.0.0.1:4000/service-1/echo/service-1-to-service-2' \
    --header 'Authorization: Bearer {authorization token}'
    ```

    **Response:**
    ```json
    {
      "echo": "[sample-service-2] echo"
    }
    ```

#### Sample Service 2 Endpoints

1.
    **Endpoint:**
    ```url
    GET http://127.0.0.1:4000/service-2/echo
    ```
    
    **Curl:**
    ```bash
    curl --location 'http://127.0.0.1:4000/service-2/echo' \
    --header 'Authorization: Bearer {authorization token}'
    ```
    
    **Respose:**
    ```json
    {
      "echo": "[sample-service-2] : echo"
    }
    ```

2.
    **Endpoint:**
    ```url
    GET http://127.0.0.1:4000/service-2/echo/service-2-to-service-1
    ```
    
    **Curl:**
    ```bash
    curl --location 'http://127.0.0.1:4000/service-2/echo/service-1-to-service-2' \
    --header 'Authorization: Bearer {authorization token}'
    ```
    
    **Respose:**
    ```json
    {
      "echo": "[sample-service-1] : echo"
    }
    ```

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.