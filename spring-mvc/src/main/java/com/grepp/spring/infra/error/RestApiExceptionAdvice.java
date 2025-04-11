package com.grepp.spring.infra.error;

import com.grepp.spring.infra.response.ApiResponse;
import com.grepp.spring.infra.response.ResponseCode;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestApiExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>>
        validatorHandler(MethodArgumentNotValidException ex){
        log.info(ex.getMessage(), ex);

        Map<String, String> errors = new LinkedHashMap<>();
        ex.getAllErrors().forEach(e -> errors.put(e.getObjectName(), e.getDefaultMessage()));
        return ResponseEntity
            .badRequest()
            .body(ApiResponse.error(ResponseCode.BAD_REQUEST, errors));
    }

}
