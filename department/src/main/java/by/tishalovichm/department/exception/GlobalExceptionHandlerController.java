package by.tishalovichm.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionInfo(
                        String.format("Resource with id = %s", e.getResourceId())
                ),
                HttpStatus.NOT_FOUND
        );
    }

}
