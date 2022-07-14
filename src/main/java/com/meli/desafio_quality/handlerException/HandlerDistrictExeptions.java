package com.meli.desafio_quality.handlerException;

import com.meli.desafio_quality.exception.DistrictAlreadyExist;
import com.meli.desafio_quality.exception.DistrictNotFound;
import com.meli.desafio_quality.exception.ErrorResponseDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class HandlerDistrictExeptions {

    @ExceptionHandler(DistrictNotFound.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorNotFound(DistrictNotFound districtNotFound) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Bad Request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .link("https://http.cat/400")
                        .message(districtNotFound.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DistrictAlreadyExist.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorNotFound(DistrictAlreadyExist districtAlreadyExist) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .link("https://http.cat/404")
                        .message(districtAlreadyExist.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

}
