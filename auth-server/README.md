# Auth Server

## Overview

The Auth Server is a part of a broader Spring Cloud Microservice example project. It serves as the cornerstone of user security by managing authentication and authorization processes. The server ensures secure access to protected resources across the microservice ecosystem. Built using Java 17 and incorporating state-of-the-art security protocols like OAuth2 and OpenID Connect, the Auth Server offers a robust and secure environment for user management.

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

## OAuth2

### Proof Key for Code Exchange (PKCE)

Proof Key for Code Exchange (PKCE) is an OAuth 2.0 extension that adds an additional layer of security to the authorization flow for public clients by preventing the interception of authorization codes by malicious actors. It is particularly useful for Single Page Applications (SPAs) and mobile applications.

To use PKCE, the client should generate a unique **code_verifier** and a corresponding **code_challenge** for every authorization request as part of the Authorization Code flow.

Here are some example values:

- Sample **code_verifier**: "tClcOwZdqiPHHuMo0CyxMked9r1NJ_5_BicA0FI1Q0E"
- Sample **code_challenge**: "Q0J7-pF3nmAP3XrTmUt6DEFL9vKG9_1V12fXXMTVIqk"
- Sample **code_challenge_method**: "S256"

The **code_challenge** is a Base64-URL-encoded string of the SHA256 hash of the **code_verifier**. The **code_challenge_method** should be "S256".

Include these parameters when directing the user to the authorization URL and when exchanging the authorization code for an access token. It's crucial to remember that these values should be regenerated for each new authorization request to maintain a high level of security.

### Authorization Flow

1.  **Authorization Request URL:** The client application initiates the authorization request to the Authorization Server.

    ```url
    http://127.0.0.1:5500/oauth2/authorize?response_type=code&client_id=web-client-id&scope=openid&redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc&code_challenge={code_challenge}&code_challenge_method={code_challenge_method}
    ```

2.  **Login URL:** The user is prompted to enter their login credentials.

    ```url
    http://127.0.0.1:5500/login
    ```

3.  **Authorization Grant URL:** After successful login, the user is redirected to this URL to give consent to the client application to access their protected resources.

    ```url
    http://127.0.0.1:5500/oauth2/authorize?response_type=code&client_id=web-client&scope=openid&redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc&code_challenge={code_challenge}&code_challenge_method={code_challenge_method}&continue
    ```

4.  **Authorization Code URL:** Post user's consent, they are redirected to this URL equipped with a one-time authorization code.

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
    --data-urlencode 'redirect_uri=http://127.0.0.1:4200/login/oauth2/code/web-client-oidc' \
    --data-urlencode 'code_verifier={code_verifier}'
    ```

## Contributing

Please feel free to submit issues, fork the repository, and send pull requests to contribute to the project.

## License
This project is licensed under the terms of the MIT License.