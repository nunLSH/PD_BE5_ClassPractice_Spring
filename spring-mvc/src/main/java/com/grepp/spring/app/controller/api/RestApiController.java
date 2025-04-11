package com.grepp.spring.app.controller.api;

import com.grepp.spring.app.controller.api.form.RestForm;
import com.grepp.spring.app.controller.api.payload.RestPayload;
import com.grepp.spring.app.controller.api.validator.RestFormValidator;
import com.grepp.spring.infra.error.exceptions.RestApiException;
import com.grepp.spring.infra.response.ApiResponse;
import com.grepp.spring.infra.response.ResponseCode;
import jakarta.validation.Valid;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Slf4j
public class RestApiController {

    @InitBinder("restForm")
    public void restFormBinder(WebDataBinder binder){
        binder.addValidators(new RestFormValidator());
    }

    // content-type : application/json
    @GetMapping("test")
    // @ResponseBody
    public RestPayload test(RestForm form){
        log.info("form : {}", form);
        OffsetDateTime now = OffsetDateTime.now();
        return new RestPayload(1, "aaa@aaa.com", now, now.toEpochSecond());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<RestPayload>> get(){
        OffsetDateTime now = OffsetDateTime.now();
        RestPayload restPayload =  new RestPayload(1, "aaa@aaa.com", now, now.toEpochSecond());
        return ResponseEntity.ok(ApiResponse.success(restPayload));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<RestPayload>> delete(){
        OffsetDateTime now = OffsetDateTime.now();
        return ResponseEntity.ok(ApiResponse.noContent());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RestPayload>> post(
        @Valid
        @RequestBody
        RestForm form
    ){
        log.info("form : {}", form);
        OffsetDateTime now = OffsetDateTime.now();
        RestPayload restPayload =  new RestPayload(1, "aaa@aaa.com", now, now.toEpochSecond());
        return ResponseEntity.ok(ApiResponse.success(restPayload));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<RestPayload>> put(
        @Valid
        @RequestBody
        RestForm form
    ){
        OffsetDateTime now = OffsetDateTime.now();
        RestPayload restPayload =  new RestPayload(1, "aaa@aaa.com", now, now.toEpochSecond());
        return ResponseEntity.ok(ApiResponse.success(restPayload));
    }

    @GetMapping("error")
    public ResponseEntity<ApiResponse<RestPayload>> error(){
        throw new RestApiException(ResponseCode.INTERNAL_SERVER_ERROR);
    }
}
