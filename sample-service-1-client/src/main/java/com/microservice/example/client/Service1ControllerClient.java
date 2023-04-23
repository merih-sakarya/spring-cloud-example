package com.microservice.example.client;

import com.microservice.example.model.EchoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("${feign.client.serviceId}")
public interface Service1ControllerClient {

    @RequestMapping(value = "/echo", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    EchoResponse getEcho();
}
