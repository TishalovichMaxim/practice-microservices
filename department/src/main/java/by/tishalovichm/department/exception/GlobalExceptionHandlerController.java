package by.tishalovichm.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleResourceNotFound(
            ResourceNotFoundException e) {

        return new ResponseEntity<>(
                new ExceptionInfo(
                        String.format("Resource with %s = %s not found",
                                e.getField(),
                                e.getValue().toString())
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

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
