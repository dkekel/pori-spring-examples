package cern.pori.spring.exception;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpringCampusExceptionHandler {

  @ExceptionHandler(UnsupportedOperationException.class)
  public ResponseEntity<String> handleUnsupportedOperationException(
      UnsupportedOperationException ex) {
    return new ResponseEntity<>("We're not ready yet: " + ex.getMessage(),
        HttpStatus.I_AM_A_TEAPOT);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleException(NoSuchElementException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
  }
}
