package com.ss.utopia.controllers;

import com.ss.utopia.exceptions.ExpiredTokenExpception;
import com.ss.utopia.exceptions.TokenAlreadyIssuedException;
import com.ss.utopia.exceptions.TokenNotFoundExpection;
import com.ss.utopia.exceptions.UserAlreadyExistsException;
import com.ss.utopia.exceptions.UserNotFoundException;
import java.net.ConnectException;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

  @ExceptionHandler(UserAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponseEntity<Object> userAlreadyExistsException(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(TokenAlreadyIssuedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponseEntity<Object> tokenAlreadyExistsException(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> userNotFoundException(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(TokenNotFoundExpection.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> tokenNotFoundExeption(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ExpiredTokenExpception.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> tokenNotFoundException(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> invalidMessage() {
    return new ResponseEntity<>(
      "Invalid HTTP message content",
      HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> illegalArgumentException(Throwable err) {
    return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<Object> sqlException() {
    return new ResponseEntity<>(
      "Service temporarily unavailabe.",
      HttpStatus.SERVICE_UNAVAILABLE
    );
  }

  @ExceptionHandler(ConnectException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<Object> invalidConnection() {
    return new ResponseEntity<>(
      "Service temporarily unavailabe.",
      HttpStatus.SERVICE_UNAVAILABLE
    );
  }
}
