package ru.yandex.backend.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("code", HttpStatus.BAD_REQUEST);
        params.put("message", ex.getMessage());
        return handleExceptionInternal(ex, params, headers, status, request);
    }
}
