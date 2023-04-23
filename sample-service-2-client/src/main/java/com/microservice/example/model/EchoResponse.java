package com.microservice.example.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class EchoResponse {

    @NonNull private String echo;
}
