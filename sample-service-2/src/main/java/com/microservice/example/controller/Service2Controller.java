package com.microservice.example.controller;

import com.microservice.example.client.Service1ControllerClient;
import com.microservice.example.model.EchoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/")
public class Service2Controller {

    private Service1ControllerClient service1ControllerClient;

    @Autowired
    public Service2Controller(Service1ControllerClient service1ControllerClient) {
        this.service1ControllerClient = service1ControllerClient;
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    EchoResponse echo(@AuthenticationPrincipal Jwt principal, @RequestHeader(value = "X-Custom-Header", required = false) String xCustomHeader) {
        // The audience is used to determine whether the token was issued for a web client ("web-client-id") or a core client ("core-client-id").
        List<String> audience = principal.getClaim("aud");
        if (audience.contains("web-client-id")) {
            // Token was generated using the Authorization Code Grant Type
            log.info("[sample-service-2] : Authentication token (authorization_code grant type) : " + principal.getTokenValue());
        } else if (audience.contains("core-client-id")) {
            // Token was generated using the Client Credentials Grant Type
            log.info("[sample-service-2] : Authentication token (client_credentials grant type) : " + principal.getTokenValue());
            log.info("[sample-service-2] : X-Custom-Header : " + xCustomHeader);
        }
        return new EchoResponse("[sample-service-2] echo");
    }

    @RequestMapping(value = "/echo/service-2-to-service-1", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    EchoResponse echoServiceToService(@AuthenticationPrincipal Jwt principal) {
        // Token was generated using the Authorization Code Grant Type
        log.info("[sample-service-2] : Authentication token (authorization_code grant type) : " + principal.getTokenValue());
        log.info("[sample-service-2] : Starting request to [sample-service-1]");
        EchoResponse echo = service1ControllerClient.getEcho(); // Do not directly map the response! Use Dozer, MapStruct etc. to map the object.
        log.info("[sample-service-2] : The request to [sample-service-1] has been completed");
        log.info("[sample-service-2] : The response value returned from [sample-service-1] : " + echo.getEcho());
        return echo;
    }
}



