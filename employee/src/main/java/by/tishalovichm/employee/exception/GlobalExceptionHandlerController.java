package by.tishalovichm.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(
                new ExceptionInfo(
                        String.format("Resource with id = %d not found", e.getResourceId())
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationFieldErrorInfo>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        List<ValidationFieldErrorInfo> errorInfos = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(
                error -> errorInfos.add(
                        new ValidationFieldErrorInfo(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                )
        );

        return new ResponseEntity<>(
                errorInfos,
                HttpStatus.BAD_REQUEST
        );
    }

}
