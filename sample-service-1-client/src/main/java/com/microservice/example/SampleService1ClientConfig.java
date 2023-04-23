package com.microservice.example;

import com.microservice.example.config.YamlPropertySourceFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableFeignClients
@PropertySource(value = "classpath:sample-service-1-client-config.yml", factory = YamlPropertySourceFactory.class)
public class SampleService1ClientConfig {

}
