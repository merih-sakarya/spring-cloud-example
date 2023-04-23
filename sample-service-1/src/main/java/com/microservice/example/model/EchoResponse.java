package com.microservice.example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class EchoResponse {

    @NonNull private String echo;
}
