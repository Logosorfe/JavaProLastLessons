package org.telran.ticketapp.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({TravelTicketNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity handleNotFoundException(
            Exception e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EmailNotUniqueException.class)
    public ResponseEntity handleEmailNotUniqueException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
