package com.microservice.example.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

/**
 * OpenFeign is a Java-based HTTP client that makes it easier to make HTTP requests to other services.
 * OpenFeign can be configured with interceptors that allow you to add, remove, or modify the headers
 * or other parts of the HTTP request before it is sent.
 *
 * Some common use cases for OpenFeign request interceptors are:
 * - Adding authentication tokens to the request headers
 * - Adding or modifying request headers, such as content type or user-agent
 * - Adding correlation IDs or other metadata to the request headers
 * - Logging the request and response for debugging purposes
 * - Modifying the request payload, such as adding or removing fields
 */
@Slf4j
@RequiredArgsConstructor
public class FeignRequestInterceptor implements RequestInterceptor {

    private final OAuth2AuthorizedClientManager authorizedClientManager;

    /**
     * The apply() method is an implementation of the RequestInterceptor interface for OpenFeign,
     * which allows you to modify outgoing HTTP requests before they are sent to the server.
     */
    @Override
    public void apply(RequestTemplate request) {
        if (this.authorizedClientManager == null) {
            return;
        }

        // As of OpenFeign version 4.0.0, OAuth2 clientRegistrationId configuration parameter has been added.
        // This feature retrieves the access token and sets it as a Bearer token automatically using registered Oauth2 Client.
        // To use this feature, we need to set the following two properties in our application.yml or .properties file:
        // - spring.cloud.openfeign.oauth2.enabled = true
        // - spring.cloud.openfeign.oauth2.clientRegistrationId = {Registered OAuth2 Client ID}
        // Once these properties are set, OpenFeign will automatically handle OAuth2 authentication for us.

        // The commented out line below shows how we would manually set the Authorization header otherwise:
        // Use the OAuth2AuthorizedClientManager to get OAuth2AuthorizedClient that holds an OAuth2AccessToken
        // request.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", accessToken.getTokenValue()));

        // Set custom header as an example
        // This is just an example of how to add a custom header.
        request.header("X-Custom-Header", "Custom Header Value");
    }
}
