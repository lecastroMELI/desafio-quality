package com.meli.desafio_quality.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDetails {

    private String title;
    private int status;
    private String link;
    private String message;
    private LocalDateTime timestamp;

}