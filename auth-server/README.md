# Auth Server

The Auth Server is a part of the Spring Cloud Microservice example. It is responsible for handling authentication and authorization of users, providing secure access to protected resources across microservices.

## Features

- OAuth2 Authorization Flow and OpenID Connect 1.0
- Eureka Client for service registration and discovery
- Spring Cloud Config for centralized configuration management
- YAML configuration for easy customization
- Java 17 for the latest language features

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
java -jar target/auth-server-0.0.1-SNAPSHOT.jar
```

`auth-server` will start and register itself with the Discovery Server and be ready to handle authentication and authorization requests.

## Configuration

The project uses the `bootstrap.yml` file for its initial configuration. It connects to the Config Server to fetch centralized configuration settings, allowing for easy management and updates of the application's configuration.


## OAuth2 Authorization Flow

1.  **Authorization Request URL:** The client application initiates the authorization request to the Authorization Server.

    ```url
    http://127.0.0.1:5500/oauth2/authorize?response_type=code&client_id=web-client-id&scope=openid&redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc
    ```

2.  **Login URL:** The user is prompted to enter their login credentials.

    ```url
    http://127.0.0.1:5500/login
    ```

3.  **Authorization Grant URL:** After the user logs in, they are redirected to this URL to authorize the client application to access their protected resources.

    ```url
    http://127.0.0.1:5500/oauth2/authorize?response_type=code&client_id=web-client&scope=openid&redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc&continue
    ```

4.  **Authorization Code URL:** After the user grants authorization, they are redirected to this URL with a one-time authorization code.

    ```url
    http://127.0.0.1:4200/login/oauth2/code/web-client-oidc?code={ONE-TIME-CODE}
    ```

5.  **Exchange Authorization Code for Access Token:** The client application uses the following cURL command to exchange the authorization code for an access token.

    ```bash
    curl --location --request POST 'http://127.0.0.1:5500/oauth2/token' \
    --header 'Authorization: Basic d2ViLWNsaWVudDpjbGllbnQtc2VjcmV0LTE=' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'code={one time code associated with the authentication event}' \
    --data-urlencode 'grant_type=authorization_code' \
    --data-urlencode 'redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc'
    ```

## Note
Please be aware that the current implementation of the Auth Server does not yet support Proof Key for Code Exchange (PKCE). PKCE is an OAuth 2.0 extension that adds an additional layer of security to the authorization flow for public clients by preventing the interception of authorization codes by malicious actors. It is particularly useful for Single Page Applications (SPAs) and mobile applications. We have plans to implement this feature soon to enhance the security of the authorization flow for public clients. In the meantime, ensure that you update your auth-server application to support PKCE once it is available and validate the code_challenge and code_verifier during the authorization flow.

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.