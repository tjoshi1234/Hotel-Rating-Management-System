package com.tapan.hotel.service.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
