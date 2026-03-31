package lk.ijse.smarttravelapi.exception;

import lk.ijse.smarttravelapi.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGenaralException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",e.getMessage())
                ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse<String>> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(new APIResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal NUll Pointer Error",e.getMessage())
                ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<String>> handleGeneralException
            (MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>
                (new APIResponse<>
                        (HttpStatus.BAD_REQUEST.value(), "Validation error",
                                errors.toString()), HttpStatus.BAD_REQUEST);
    }
}

