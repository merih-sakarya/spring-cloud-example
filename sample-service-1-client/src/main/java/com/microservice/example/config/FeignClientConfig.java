package com.microservice.example.config;

import com.microservice.example.interceptor.FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

/**
 * Configuration class for Feign clients that enables them to inherit the specified configuration globally.
 * By annotating this class with @Configuration, you can apply this configuration to all Feign clients.
 * If you want to specify a different configuration for a specific Feign client, you can use the "configuration" attribute
 * of the @FeignClient annotation to refer to another configuration class.
 * Ex: @FeignClient(value = "client-serviceId", configuration = {FooFeignClientConfig.class})
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor(OAuth2AuthorizedClientManager authorizedClientManager) {
        return new FeignRequestInterceptor(authorizedClientManager);
    }
}
