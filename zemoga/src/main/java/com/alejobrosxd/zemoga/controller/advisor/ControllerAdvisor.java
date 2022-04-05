package com.alejobrosxd.zemoga.controller.advisor;

import com.alejobrosxd.zemoga.core.exception.APIException;
import com.alejobrosxd.zemoga.core.exception.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(
        NotFoundException exception) {
        return new ResponseEntity<>(Map.of("message", exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handlePOSException(
        APIException exception) {
        return new ResponseEntity<>(Map.of("message", exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> additionalInformation = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            additionalInformation.add(((FieldError) error).getField() + ":" + error.getDefaultMessage());
        });
        return new ResponseEntity<>(Map.of("message", String.join(", ", additionalInformation)),
            HttpStatus.BAD_REQUEST);
    }

}
